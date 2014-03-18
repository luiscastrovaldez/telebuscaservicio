package com.pacifico.telebusca.servicio.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
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
		int advertenciaFechas = 0;
		StringBuffer errores = new StringBuffer();
		boolean isValido = Boolean.FALSE;
		audiosValidos = new ArrayList<Object>();
		audiosNoValidos = new ArrayList<Object>();
		
		try {
			Llamada llamada;
			int fila=0;
			this.serializer = new Persister();
			
			String encoding = System.getProperty("file.encoding");
			System.out.println(encoding);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(xml), "ISO-8859-1"));

			String str;
			StringBuilder todo = new StringBuilder(" ");
			
			while ((str = in.readLine()) != null) {
				// System.out.println(str.trim());
				if (fila!=0){
					todo.append(str.trim());	
				}				
				fila++;
			}
			
			in.close();
			
			
			
			
			this.registros = this.serializer.read(Registros.class, todo.toString());
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
					if (!validarDniCliente(llamada.getDniCliente())) {
						dniCliente++;
						isValido = Boolean.TRUE;
						errores.append(" Error Dni Cliente "
								+ llamada.getDniCliente());
						errores.append(", ");
						
					}

					if (!validarApellidos(llamada.getApellidoPaternoCliente())) {
						apellidoPaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Paterno "
								+ llamada.getApellidoPaternoCliente());
						errores.append(", ");
					}

					if (!validarApellidos(llamada.getApellidoMaternoCliente())) {
						apellidoMaterno++;
						isValido = Boolean.TRUE;
						errores.append(" Error Apellido Materno "
								+ llamada.getApellidoMaternoCliente());
						errores.append(", ");
					}

					if (!validarNombres(llamada.getNombresCliente())) {
						nombresCliente++;
						isValido = Boolean.TRUE;
						errores.append(" Error Nombre Cliente " + llamada.getNombresCliente());
						errores.append(", ");
					}
				}
				if (!validarTelefono(llamada.getTelefonoCliente())) {
					telefonoNumeroCliente++;
					isValido = Boolean.TRUE;
					errores.append(" Error TeleFono Cliente " + llamada.getTelefonoCliente());
					errores.append(", ");
				}
				if (!validarFecha(llamada.getFechaVenta(), "dd/MM/yyyy")) {
					fechaVenta++;
					isValido = Boolean.TRUE;
					errores.append(" Error Fecha Venta " + llamada.getFechaVenta());
					errores.append(", ");
				}
				if (!validarFechaMes(llamada.getFechaVenta(), "dd/MM/yyyy")) {										
					errores.append(" Advertencia Fecha Venta mayor a 30 dias" + llamada.getFechaVenta());
					errores.append(", ");
					advertenciaFechas++;
				}
				
				
				

				if (!validarHora(llamada.getHoraVenta())) {
					horaVenta++;
					isValido = Boolean.TRUE;
					errores.append(" Error Hora Venta " + llamada.getHoraVenta());
					errores.append(", ");
				}
				if (!validarDni(llamada.getDniAsesor())) {
					dniAsesor++;
					isValido = Boolean.TRUE;
					errores.append(" Error  DNI Asesor " + llamada.getDniAsesor());
					errores.append(", ");
				}
				if (!validarProceso(llamada.getProceso())) {
					proceso++;
					isValido = Boolean.TRUE;
					errores.append(" Error Proceso " + llamada.getProceso());
					errores.append(", ");
				}
				


				if (!validarVdn(llamada.getVdn(),atento2.equals(llamada.getEmpresa()))) {
					vdn++;
					isValido = Boolean.TRUE;
					errores.append(" Error VDN " + llamada.getVdn());
					errores.append(", ");
				}

				if (!validarSkill(llamada.getSkill(),atento2.equals(llamada.getEmpresa()))) {
					skill++;
					isValido = Boolean.TRUE;
					errores.append(" Error Skill " + llamada.getSkill());
					errores.append(", ");
				}
			
				
				
				if (!validarPath(this.rutaAudio, llamada.getRutaAudio())) {
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
			validacionErrores.setAdvertenciaFechas(advertenciaFechas);
		} catch (Exception e) {
			e.printStackTrace();
			
			
			if (e.getCause()!=null){
				if (e.getCause().getCause()!=null){
					if(!e.getCause().getCause().getMessage().equals("")){
						if(e.getCause().getCause().getMessage().contains("Cannot release connection")||
								e.getCause().getCause().getMessage().contains("Cannot open connection")||
								e.getCause().getCause().getMessage().contains("JDBC rollback failed")){								
							throw new Exception("Base de datos no disponible.");
							
						}
					}
				}	
			}
			
			logger.error("Error en la validacion del archivo xml. ");
			throw new Exception("Error en la validacion del archivo xml " + xml.getName());
		}
		logger.info("Terminando validacion del archivo xml " + xml.getName());
		return this.validacionErrores;
	}

	
	
	private boolean validarSkill(String skill,boolean isAtento2) {
		// TODO Auto-generated method stub
		if (isAtento2){ 
			if(skill == null){
				return Boolean.FALSE;
			}
			if("".equals(skill)){
				return Boolean.FALSE;
			}
			if(skill.length() != 10){
				return Boolean.FALSE;
			}
			if(!StringUtils.isAlphanumeric(skill)){
				return Boolean.FALSE;
			}	
		} else {
			if (skill !=null){
				if(skill.length() != 10){
					return Boolean.FALSE;
				}	
			} else {
				return Boolean.TRUE;
			}
			 
			if(!StringUtils.isAlphanumeric(skill)){
				return Boolean.FALSE;
			}
		}
		
		
		return Boolean.TRUE;
	}

	private boolean validarVdn(String vdn, boolean isAtento2) {
		// TODO Auto-generated method stub
		if (isAtento2){
			if(vdn == null){
				return Boolean.FALSE;
			}
			if("".equals(vdn)){
				return Boolean.FALSE;
			}
			if(vdn.length() != 10){
				return Boolean.FALSE;
			}
			if(!StringUtils.isAlphanumeric(vdn)){
				return Boolean.FALSE;
			}	
		} else {
			if (vdn != null){
				if(vdn.length() != 10){
					return Boolean.FALSE;
				}	
			} else {
				return Boolean.TRUE;
			}
			
			if(!StringUtils.isAlphanumeric(vdn)){
				return Boolean.FALSE;
			}
		}
		
		return Boolean.TRUE;
	}

	private boolean validarDniCliente(String dniCliente) {
		// TODO Auto-generated method stub
		if (dniCliente == null){
			return Boolean.FALSE;	
		}
		if ("".equals(dniCliente)){
			return Boolean.FALSE;
		}
		
		if (dniCliente.length() < 8 || dniCliente.length() > 15){
			return Boolean.FALSE;
		}
		
		if (!StringUtils.isNumeric(dniCliente)){
			return Boolean.FALSE;
		}
		
		
		return Boolean.TRUE;
	}
	
	private boolean validarDni(String dniCliente) {
		// TODO Auto-generated method stub
		if (dniCliente == null){
			return Boolean.FALSE;	
		}
		if ("".equals(dniCliente)){
			return Boolean.FALSE;
		}
		
		if (dniCliente.length() != 8){
			return Boolean.FALSE;
		}	
		if (!StringUtils.isNumeric(dniCliente)){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private boolean validarNombres(String nombres){
		if (nombres == null){
			return Boolean.FALSE;
		}
		if ("".equals(nombres)){
			return Boolean.FALSE;
		}
		
		if(nombres.length() > 40){
			return Boolean.FALSE;
		}
		
		if (!StringUtils.isAlphaSpace(nombres)){
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	private boolean validarApellidos(String apellido){
		if (apellido == null){
			return Boolean.FALSE;
		}
		if ("".equals(apellido)){
			return Boolean.FALSE;
		}
		
		if(apellido.length() > 40){
			return Boolean.FALSE;
		}
		
		if (!StringUtils.isAlphaSpace(apellido)){
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
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
	
	private boolean validarTelefono(String telefono){
		
		if ("".equals(telefono)  || telefono == null){
			return Boolean.FALSE;
		}
		
		if (telefono.contains("-")){
			return Boolean.FALSE;
		}
		if (telefono.length()!= 9){
			return Boolean.FALSE;
		}
		if (!StringUtils.isNumeric(telefono)){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private boolean validarProceso(String proceso){
		if ("".equals(proceso) || proceso == null){
			return Boolean.FALSE;
		}
		if ("IN".equals(proceso) || "OUT".equals(proceso)){
			return Boolean.TRUE; 
		}
		if (proceso.length() < 2 || proceso.length() > 3){
			return Boolean.FALSE;
		}
		if (!StringUtils.isAlpha(proceso)){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private boolean validarHora(String hora){
		if ("".equals(hora) || hora == null){
			return Boolean.FALSE;
		}
		if(hora.length() != 8){
			return Boolean.FALSE;
		}
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date formattedDate = null;
		try {
			formattedDate = df.parse(hora);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	private boolean validarPath(String pathEmpresa, String rutaXml){
		
		logger.info("pathEmpresa " + pathEmpresa);
		logger.info("rutaXml " + rutaXml);
		
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		
		
		
		
	}
	
	
	private boolean validarFechaMes(String dateToValidate, String dateFromat) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		try {
			Date date = sdf.parse(dateToValidate);
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(date);

			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(new Date());
			
			DateTime dateTime1 = new DateTime(startCalendar.getTimeInMillis());
			DateTime dateTime2 = new DateTime(endCalendar.getTimeInMillis());
			
			Days days = Days.daysBetween(dateTime1, dateTime2);
			
			if (days.getDays() > 30){
				return Boolean.FALSE;
			}
			return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return Boolean.TRUE;
	}
	
	private boolean validarFecha(String dateToValidate, String dateFromat) {
		if (dateToValidate == null || "".equals(dateToValidate)) {
			return Boolean.FALSE;
		}
		
		if(dateToValidate.length() != 10){
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
	
	
	
	public File descargarArchivoResgistroNoValidos(List<Object> audiosNoValidos)
			throws Exception {
		Serializer serializer = new Persister();
		Registros registros = new Registros();
		List<Llamada> llamadas = new ArrayList<Llamada>();
		File source = null;
		try {
						
			for (Iterator<Object> iterator = audiosNoValidos.iterator(); iterator
					.hasNext();) {
				Llamada llamada = (Llamada) iterator.next();
				llamadas.add(llamada);
			}

			if (llamadas != null && !llamadas.isEmpty()) {
				registros.setLlamadas(llamadas);
			}

			source = File.createTempFile("abc", ".xml");
			serializer.write(registros, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return source;
	}
	
	public File descargarAudio(int codEmpresa, final String path)
			throws Exception {
		// TODO Auto-generated method stub
		String urlPath = null;
		Empresa empresa = new Empresa();
		File source = null;;
		try {
			empresa = empresaServicio.buscarEmpresaPorCodigo(codEmpresa);
			if (empresa != null) {
				urlPath = empresa.getCarpeta();
			}
			source = new File(urlPath + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
