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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	
	@Value("#{telebusca['jboss.home.linux']}")
	private String jbossLinux;
	
	@Value("#{telebusca['jboss.home.win']}")
	private String jbossWindows;
	
	@Value("#{telebusca['ruta.audios']}")
	private String rutaAudios;
	
	@Value("#{telebusca['dynamicall']}")
	private String dynamicall;
	
	@Value("#{telebusca['atento1']}")
	private String atento1;
	
	@Value("#{telebusca['contacto']}")
	private String contacto;
	
	@Value("#{telebusca['atento2']}")
	private String atento2;
	

		
	
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
				if (!atento2.equals(llamada.getEmpresa())) {
					if ("".equals(llamada.getDniCliente()) || llamada.getDniCliente() == null) {
						dniCliente++;
						isValido = Boolean.TRUE;
						errores.append(" Error Dni Cliente "
								+ llamada.getDniCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getApellidoPaternoCliente()) || llamada.getApellidoPaternoCliente() == null) {
						apellidoPaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Paterno "
								+ llamada.getApellidoPaternoCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getApellidoMaternoCliente())|| llamada.getApellidoMaternoCliente()== null) {
						apellidoMaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Materno "
								+ llamada.getApellidoMaternoCliente());
						errores.append(", ");
					}

					if ("".equals(llamada.getNombresCliente())|| llamada.getNombresCliente() == null) {
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

				if (validadHora(llamada.getHoraVenta())) {
					horaVenta++;
					isValido = Boolean.TRUE;
					errores.append(" Error Hora Venta " + llamada.getHoraVenta());
					errores.append(", ");
				}
				if ("".equals(llamada.getDniAsesor()) || llamada.getDniAsesor()== null) {
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
				if (atento2.equals(llamada.getEmpresa())) {

					if ("".equals(llamada.getVdn()) || llamada.getVdn()==null) {
						vdn++;
						isValido = Boolean.TRUE;
						errores.append(" Error VDN" + llamada.getVdn());
						errores.append(", ");
					}

					if ("".equals(llamada.getSkill()) || llamada.getSkill()== null) {
						skill++;
						isValido = Boolean.TRUE;
						errores.append(" Error Skill " + llamada.getSkill());
						errores.append(", ");
					}
				}
				
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
			logger.error("Error en la validacion del archivo xml. ");
			throw new Exception("Error en la validacion del archivo xml " + xml.getName());
		}
		logger.info("Terminando validacion del archivo xml " + xml.getName());
		return this.validacionErrores;
	}

	
	
	private boolean validarEmpresa(String nombreEmpresa){
		if ("".equals(nombreEmpresa) || nombreEmpresa == null){
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
		if ("".equals(telefono)  || telefono == null){
			return Boolean.FALSE;
		}		
		if (telefono.length()!= 9){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private boolean validadProceso(String proceso){
		if ("".equals(proceso) || proceso == null){
			return Boolean.FALSE;
		}
		if ("IN".equals(proceso) || "OUT".equals(proceso)){
			return Boolean.TRUE; 
		}
		return Boolean.FALSE;
	}
	
	private boolean validadHora(String hora){
		if ("".equals(hora) || hora == null){
			return Boolean.FALSE;
		}
		
		return Boolean.FALSE;
	}
	
	private boolean validadPath(String pathEmpresa, String rutaXml){
		
		logger.info("pathEmpresa " + pathEmpresa);
		logger.info("rutaXml " + rutaXml);
		
		if ("".equals(rutaXml) || rutaXml == null){
			return Boolean.FALSE;
		}
		File directorio = null;
		String[] splitPath = rutaXml.split("/");
		if (isWindows()) {			
			directorio = new File(jbossWindows + "/" +rutaAudios+"/"+ pathEmpresa + "/" + splitPath[1]);	
		} else {
			directorio = new File(jbossLinux+ "/" +rutaAudios+"/"+ pathEmpresa + "/" + splitPath[1]);
		}				
		logger.info("directorio " + directorio.getAbsolutePath());
		if (!directorio.isDirectory()){
			return Boolean.FALSE; 	
		}		
		
		String[] archivos = directorio.list();
		if (archivos != null ){
			List<String> listaArchivos = Arrays.asList(archivos);			
			logger.info("nombre de archivo " + splitPath[2] + " existe archivo "+listaArchivos.contains(splitPath[2]));
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
			path = jbossWindows + rutaAudios+ path;
		} else {			
			path = jbossLinux + rutaAudios+ path;
		}
		
		File source = new File(path);
		System.out.println("archivo existe "+ source.exists());
		return source;
	}
	public static boolean isWindows() {
		 
		return (OS.indexOf("win") >= 0);
 
	}
}
