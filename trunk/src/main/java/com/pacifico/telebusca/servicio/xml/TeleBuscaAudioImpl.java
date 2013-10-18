package com.pacifico.telebusca.servicio.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.stereotype.Service;

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

	public ValidacionErrores parseaFileXml(File xml) {
		try {
			Llamada llamada;
			this.serializer = new Persister();
			this.registros = this.serializer.read(Registros.class, xml);
			this.llamadas = this.registros.getLlamadas();

			for (Iterator iterator = this.llamadas.iterator(); iterator
					.hasNext();) {
				llamada = (Llamada) iterator.next();
				List<Object> elementos = llamada.getList();

				for (Iterator iterator1 = elementos.iterator(); iterator1
						.hasNext();) {
					String elemento = (String) iterator1.next();
					logger.info("elementos = " + elemento);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.validacionErrores;
	}

	public List<Object> parseaFileXml(String xml) {
		logger.info("parseaFileXml = ");
		try {
			Llamada llamada;
			this.serializer = new Persister();
			this.registros = this.serializer.read(Registros.class, xml);
			this.llamadas = this.registros.getLlamadas();

			for (Iterator iterator = this.llamadas.iterator(); iterator
					.hasNext();) {
				llamada = (Llamada) iterator.next();
				List<Object> elementos = llamada.getList();

				for (Iterator iterator1 = elementos.iterator(); iterator1
						.hasNext();) {
					String elemento = (String) iterator1.next();
					logger.info("elementos = " + elemento);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void escucharAudio() {
		// TODO Auto-generated method stub

	}

	public ValidacionErrores validarArchivoXml(File xml) {
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

	public ValidacionErrores validarArchivoXml(String xml) {
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
				);
		}
		logger.info("Terminando validacion del archivo xml ");
		return this.validacionErrores;
	}
	
	public void descargarArchivoResgistroNoValidos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void descargarAudio() {
		// TODO Auto-generated method stub

	}

}
