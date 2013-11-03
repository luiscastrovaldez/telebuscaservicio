package com.pacifico.telebusca.servicio.xml;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.commons.Constants;
import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.servicio.EmpresaServicio;
import com.pacifico.telebusca.servicio.xml.dominio.Llamada;
import com.pacifico.telebusca.servicio.xml.dominio.Registros;
import com.pacifico.telebusca.web.beans.ValidacionErrores;

@Service("teleBuscaAudio")
public class TeleBuscaAudioImpl implements TeleBuscaAudio {

	private Logger logger = Logger.getLogger(TeleBuscaAudioImpl.class);
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private Serializer serializer;
	private Registros registros;
	private List<Llamada> llamadas;
	private ValidacionErrores validacionErrores;
	private List<Object> audiosValidos;
	private List<Object> audiosNoValidos;
	private String rutaAudio;
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	public void escucharAudio() throws Exception{
		// TODO Auto-generated method stub

	}

	public ValidacionErrores validarArchivoXml(File xml) throws Exception{
		logger.info("Iniciando validacion del archivo xml " + xml.getName());
		int totalRegistros = 0;
		int registrosValidos = 0;
		int registrosNoValidos = 0;
		int codEmpresa = 0;
		int dniCliente = 0;
		int apellidoPaterno = 0;
		int apellidoMaterno = 0;
		int nombresCliente = 0;
		int telefonoNumeroCliente = 0;
		int fechaVenta = 0;
		int horaVenta = 0;
		int dniAsesor = 0;
		int proceso = 0;
		int vdn = 0;
		int skill = 0;
		int rutaAudio = 0;
		StringBuffer errores = new StringBuffer();
		boolean isValido = Boolean.FALSE;
		audiosValidos = new ArrayList<Object>();
		audiosNoValidos = new ArrayList<Object>();
		
		try {
			Llamada llamada;
			this.serializer = new Persister();
			this.registros = this.serializer.read(Registros.class, xml);
			this.llamadas = this.registros.getLlamadas();
			validacionErrores = new ValidacionErrores();
			for (Iterator<Llamada> iterator = this.llamadas.iterator(); iterator
					.hasNext();) {
				llamada = (Llamada) iterator.next();
				totalRegistros++;				
				isValido = Boolean.FALSE;
				errores = new StringBuffer();
				if (!validarEmpresa(llamada.getEmpresa())) {
					codEmpresa++;
					isValido = Boolean.TRUE;
					errores.append(" Error Empresa " + llamada.getEmpresa());
					errores.append(", ");
				}
				if (!Constants.ATENTO2.equals(llamada.getEmpresa())) {
					if ("".equals(llamada.getDniCliente())) {
						dniCliente++;
						isValido = Boolean.TRUE;
						errores.append(" Error Dni Cliente "
								+ llamada.getDniCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getApellidoPaternoCliente())) {
						apellidoPaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Paterno "
								+ llamada.getApellidoPaternoCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getApellidoMaternoCliente())) {
						apellidoMaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Materno "
								+ llamada.getApellidoMaternoCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getNombresCliente())) {
						nombresCliente++;
						isValido = Boolean.TRUE;
						errores.append(" Error " + llamada.getNombresCliente());
						errores.append(", ");
					}
				}
				if (!validadTelefono(llamada.getTelefonoCliente())) {
					telefonoNumeroCliente++;
					isValido = Boolean.TRUE;
					errores.append(" Error TeleFono Cliente " + llamada.getTelefonoCliente());
					errores.append(", ");
				}
				if (!validadFecha(llamada.getFechaVenta(), "dd/MM/yyyy")) {
					fechaVenta++;
					isValido = Boolean.TRUE;
					errores.append(" Error Fecha Venta " + llamada.getFechaVenta());
					errores.append(", ");
				}

				if ("".equals(llamada.getHoraVenta())) {
					horaVenta++;
					isValido = Boolean.TRUE;
					errores.append(" Error Hora Venta " + llamada.getHoraVenta());
					errores.append(", ");
				}
				if ("".equals(llamada.getDniAsesor())) {
					dniAsesor++;
					isValido = Boolean.TRUE;
					errores.append(" Error  DNI Asesor " + llamada.getDniAsesor());
					errores.append(", ");
				}
				if (!validadProceso(llamada.getProceso())) {
					proceso++;
					isValido = Boolean.TRUE;
					errores.append(" Error Proceso " + llamada.getProceso());
					errores.append(", ");
				}
				if (Constants.ATENTO2.equals(llamada.getEmpresa())) {

					if ("".equals(llamada.getVdn())) {
						vdn++;
						isValido = Boolean.TRUE;
						errores.append(" Error VDN" + llamada.getVdn());
						errores.append(", ");
					}

					if ("".equals(llamada.getSkill())) {
						skill++;
						isValido = Boolean.TRUE;
						errores.append(" Error Skill " + llamada.getSkill());
						errores.append(", ");
					}
				}
				logger.info("info + " + this.rutaAudio + "ruta "  + llamada.getRutaAudio());
				if (!validadPath(this.rutaAudio, llamada.getRutaAudio())) {
					rutaAudio++;
					isValido = Boolean.TRUE;
					errores.append(" Error Ruta Archivo " + llamada.getRutaAudio());
					errores.append(", ");
				}
				
				if (!isValido) {
					registrosValidos++;
					audiosValidos.add(llamada);
				} else {
					registrosNoValidos++;
					
					if (errores.length() > 0){
						llamada.setErrores(errores.toString());
					}
					audiosNoValidos.add(llamada);
				}
			}
			
			
			validacionErrores.setCodEmpresa(codEmpresa);
			validacionErrores.setDniCliente(dniCliente);
			validacionErrores.setApellidoPaterno(apellidoPaterno);
			validacionErrores.setApellidoMaterno(apellidoMaterno);
			validacionErrores.setNombresCliente(nombresCliente);
			validacionErrores.setTelefonoNumeroCliente(telefonoNumeroCliente);
			validacionErrores.setFechaVenta(fechaVenta);
			validacionErrores.setHoraVenta(horaVenta);
			validacionErrores.setDniAsesor(dniAsesor);
			validacionErrores.setProceso(proceso);
			validacionErrores.setVdn(vdn);
			validacionErrores.setSkill(skill);
			validacionErrores.setRutaAudio(rutaAudio);
			validacionErrores.setRegistrosValidos(registrosValidos);
			validacionErrores.setRegistrosNoValidos(registrosNoValidos);
			validacionErrores.setTotalRegistros(totalRegistros);
			validacionErrores.setAudiosValidos(audiosValidos);
			validacionErrores.setAudiosNoValidos(audiosNoValidos);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la validacion del archivo xml ");
			throw new Exception("Error en la validacion del archivo xml " + xml.getName());
		}
		logger.info("Terminando validacion del archivo xml " + xml.getName());
		return this.validacionErrores;
	}

	
	
	private boolean validarEmpresa(String nombreEmpresa){
		if ("".equals(nombreEmpresa)){
			return Boolean.FALSE;
		}
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas = empresaServicio.buscarEmpresaPorNombre(nombreEmpresa);
		if (empresas!=null && !empresas.isEmpty()){
			this.rutaAudio = ((Empresa)empresas.get(0)).getCarpeta();
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private boolean validadTelefono(String telefono){
		if (telefono.contains("-")){
			return Boolean.FALSE;
		}
		if ("".equals(telefono)){
			return Boolean.FALSE;
		}		
		if (telefono.length()!= 9){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private boolean validadProceso(String proceso){
		if ("".equals(proceso)){
			return Boolean.FALSE;
		}
		if ("IN".equals(proceso) || "OUT".equals(proceso)){
			return Boolean.TRUE; 
		}
		return Boolean.FALSE;
	}
	
	private boolean validadPath(String pathEmpresa, String path){
		
		logger.info("pathEmpresa " + pathEmpresa);
		logger.info("path " + path);
		
		
		
		if ("".equals(path)){
			return Boolean.FALSE;
		}
		File directorio = null;
		String[] splitPath = path.split("/");
		directorio = new File(Constants.RUTA_ABSOLUTA + pathEmpresa+ splitPath[1]);
		
		logger.info("directorio 1 " + directorio.getAbsolutePath());
		if (!directorio.isDirectory()){
			return Boolean.FALSE; 	
		}
		logger.info("directorio2 " + directorio.getAbsolutePath());
		
		String[] archivos = directorio.list();
		if (archivos != null ){
			List<String> listaArchivos = Arrays.asList(archivos);
			logger.info("listaArchivos " + listaArchivos.size() + " file 2 " + splitPath[2]);
			logger.info("valida - " + listaArchivos.contains(splitPath[2]));
			if (listaArchivos.contains(splitPath[2])){
				return Boolean.TRUE;
			}	
			
		}
		
		return Boolean.FALSE;
	}
	
	private boolean validadFecha(String dateToValidate, String dateFromat) {
		if (dateToValidate == null || "".equals(dateToValidate)) {
			return Boolean.FALSE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	
	
	public File descargarArchivoResgistroNoValidos(List<Object> audiosNoValidos) throws Exception{
		Serializer serializer = new Persister();
		Registros  registros = new Registros();
		List<Llamada> llamadas = new ArrayList<Llamada>();
		for (Iterator<Object> iterator = audiosNoValidos.iterator(); iterator.hasNext();) {
			Llamada llamada = (Llamada) iterator.next();
			llamadas.add(llamada);
		}
		
		if (llamadas !=null && !llamadas.isEmpty()){
			registros.setLlamadas(llamadas);	
		}
		
		File source = File.createTempFile("abc", ".xml");
		serializer.write(registros, source);
		return source;
	}
	
	public File descargarAudio(int codEmpresa, final String path) throws Exception{
		// TODO Auto-generated method stub
		String urlPath = null;
		Empresa empresa = new Empresa();
		empresa = empresaServicio.buscarEmpresaPorCodigo(codEmpresa);
		if (empresa!=null){
			urlPath = empresa.getCarpeta();		
		}
		File source = new File(urlPath+path);
		return source;
	}
	
	public File descargarAudio(String path) throws Exception{
		// TODO Auto-generated method stub	
		
		if (isWindows()){
			path = path.substring(11,path.length());
			path = "C:/bluestarenergy/jboss-6.1.0.Final/server/default/deploy/telebusca.war/" + path;
		}
		
		File source = new File(path);
		System.out.println("archivo existe "+ source.exists());
		return source;
	}
	public static boolean isWindows() {
		 
		return (OS.indexOf("win") >= 0);
 
	}
}
