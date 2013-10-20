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

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.servicio.EmpresaServicio;
import com.pacifico.telebusca.servicio.xml.dominio.Llamada;
import com.pacifico.telebusca.servicio.xml.dominio.Registros;
import com.pacifico.telebusca.web.beans.ValidacionErrores;

@Service("teleBuscaAudio")
public class TeleBuscaAudioImpl implements TeleBuscaAudio {

	private Logger logger = Logger.getLogger(TeleBuscaAudioImpl.class);

	private Serializer serializer;
	private Registros registros;
	private List<Llamada> llamadas;
	private ValidacionErrores validacionErrores;
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	private List<String> indicesValidos;
	
	

	public void escucharAudio() throws Exception{
		// TODO Auto-generated method stub

	}

	public ValidacionErrores validarArchivoXml(File xml) throws Exception{
		logger.info("Iniciando validacion del archivo xml " + xml.getName());
		int cont = 1;

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

		boolean isValido = Boolean.FALSE;
		try {
			Llamada llamada;
			this.serializer = new Persister();
			this.registros = this.serializer.read(Registros.class, xml);
			this.llamadas = this.registros.getLlamadas();
			validacionErrores = new ValidacionErrores();
			for (Iterator iterator = this.llamadas.iterator(); iterator
					.hasNext();) {
				llamada = (Llamada) iterator.next();
				List<Object> llamadas = llamada.getList();
				totalRegistros++;
				cont = 1;
				isValido = Boolean.FALSE;
				for (Iterator valores = llamadas.iterator(); valores.hasNext();) {
					String valor = (String) valores.next();
					logger.info("cont " + cont);
					logger.info("valor " + valor);					
					switch (cont) {
					case 1:
						if ("".equals(valor)) {
							validacionErrores.setCodEmpresa(codEmpresa++);
							isValido = Boolean.TRUE;
						}

						break;
					case 2:
						if ("".equals(valor)) {
							validacionErrores.setDniCliente(dniCliente++);
							isValido = Boolean.TRUE;
						}
						break;
					case 3:
						if ("".equals(valor)) {
							validacionErrores
									.setApellidoPaterno(apellidoPaterno++);
							isValido = Boolean.TRUE;
						}
						break;
					case 4:
						if ("".equals(valor)) {
							validacionErrores
									.setApellidoMaterno(apellidoMaterno++);
							isValido = Boolean.TRUE;
						}
						break;
					case 5:
						if ("".equals(valor)) {
							validacionErrores
									.setNombresCliente(nombresCliente++);
							isValido = Boolean.TRUE;
						}
						break;
					case 6:
						if ("".equals(valor)) {
							validacionErrores
									.setTelefonoNumeroCliente(telefonoNumeroCliente++);
							isValido = Boolean.TRUE;
						}
						break;
					case 7:
						if ("".equals(valor)) {
							validacionErrores.setFechaVenta(fechaVenta++);
							isValido = Boolean.TRUE;
						}
						break;
					case 8:
						if ("".equals(valor)) {
							validacionErrores.setHoraVenta(horaVenta++);
							isValido = Boolean.TRUE;
						}
						break;
					case 9:
						if ("".equals(valor)) {
							validacionErrores.setDniAsesor(dniAsesor++);
							isValido = Boolean.TRUE;
						}
						break;
					case 10:
						if ("".equals(valor)) {
							validacionErrores.setProceso(proceso++);
							isValido = Boolean.TRUE;
						}
						break;
					case 11:
						if ("".equals(valor)) {
							validacionErrores.setVdn(vdn++);
							isValido = Boolean.TRUE;
						}
						break;
					case 12:
						if ("".equals(valor)) {
							validacionErrores.setSkill(skill++);
							isValido = Boolean.TRUE;
						}
						break;
					case 13:
						if ("".equals(valor)) {
							validacionErrores.setRutaAudio(rutaAudio++);
							isValido = Boolean.TRUE;
						}
						break;

					default:
						break;
					}
					cont++;
				}
				if (!isValido) {
					registrosValidos++;
				} else {
					registrosNoValidos++;
				}

			}
			
			validacionErrores.setRegistrosValidos(registrosValidos);
			validacionErrores.setRegistrosNoValidos(registrosNoValidos);
			validacionErrores.setTotalRegistros(totalRegistros);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error en la validacion del archivo xml "
					+ xml.getName());
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
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private boolean validadTelefono(String telefono){
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
		File directorio = null;
		String[] splitPath = path.split("/");
		directorio = new File(pathEmpresa+"/" + splitPath[1]);
		if (directorio.isDirectory()){
			return Boolean.TRUE; 	
		}
		File[] archivos = directorio.listFiles();
		if (archivos != null ){
			List<File> listaArchivos = Arrays.asList(archivos);
			if (listaArchivos.contains(new File(splitPath[2]))){
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
	
	public ValidacionErrores validarArchivoXml(String xml) throws Exception{
		logger.info("Iniciando validacion del archivo xml " + xml);
		int cont = 1;

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

		boolean isValido = Boolean.FALSE;
		indicesValidos = new ArrayList<String>();
		try {
			Llamada llamada;
			this.serializer = new Persister();
			this.registros = this.serializer.read(Registros.class, xml);
			this.llamadas = this.registros.getLlamadas();
			validacionErrores = new ValidacionErrores();
			for (Iterator<Llamada> iterator = this.llamadas.iterator(); iterator
					.hasNext();) {
				llamada = (Llamada) iterator.next();
				List<Object> llamadas = llamada.getList();
				totalRegistros++;
				cont = 1;
				isValido = Boolean.FALSE;
				for (Iterator<Object> valores = llamadas.iterator(); valores.hasNext();) {
					String valor = (String) valores.next();
					logger.info("cont " + cont);
					logger.info("valor " + valor);					
					switch (cont) {
					case 1:
						if (!validarEmpresa(valor)){
							codEmpresa++;
							isValido = Boolean.TRUE;
						}						
						break;
					case 2:
						if ("".equals(valor)) {
							dniCliente++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 3:
						if ("".equals(valor)) {
							apellidoPaterno++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 4:
						if ("".equals(valor)) {
							apellidoMaterno++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 5:
						if ("".equals(valor)) {
							nombresCliente++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 6:
						if (!validadTelefono(valor)) {
							telefonoNumeroCliente++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 7:
						if (!validadFecha(valor, "dd/MM/yyyy")) {
							fechaVenta++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 8:
						if ("".equals(valor)) {
							horaVenta++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 9:
						if ("".equals(valor)) {
							dniAsesor++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 10:
						if (!validadProceso(valor)) {
							proceso++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 11:
						if ("".equals(valor)) {
							vdn++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 12:
						if ("".equals(valor)) {
							skill++;							
							isValido = Boolean.TRUE;
						}
						break;
					case 13:
						if (!validadPath(null, valor) && "".equals(valor)) {
							rutaAudio++;							
							isValido = Boolean.TRUE;
						}
						break;

					default:
						break;
					}					
					cont++;
					
				}
				if (!isValido) {
					registrosValidos++;
				} else {
					registrosNoValidos++;
				}
				

			}
			if (!isValido){
				indicesValidos.add(""+cont);
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
			validacionErrores.setIndicesValidos(indicesValidos);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la validacion del archivo xml ");
			throw new Exception("Error en la validacion del archivo xml ");
		}
		logger.info("Terminando validacion del archivo xml ");
		return this.validacionErrores;
	}
	
	public File descargarArchivoResgistroNoValidos() throws Exception{
		Serializer serializer = new Persister();
		File source = File.createTempFile("abc", ".xml");
		//Registros registros = serializer.read(Registros.class, source);
		return source;
	}
	
	public File descargarAudio() throws Exception{
		// TODO Auto-generated method stub
		File source = File.createTempFile("abc", ".mp3");
		return source;
	}

}
