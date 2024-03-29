package com.pacifico.telebusca.servicio;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.AudioDAO;
import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Audio;
import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.servicio.xml.dominio.Llamada;
import com.pacifico.telebusca.util.Util;

@Service("audioServicio")
@Transactional
public class AudioServicioImpl implements AudioServicio {

	@Autowired
	private AudioDAO audioDAO;

	@Autowired
	private EmpresaDAO empresaDAO;

	public void guardarAudios(List<Object> llamadas, String nombreUsuario) {	
		Audio audio;
		List<Empresa> empresas;
		Empresa empresa;
		for (Iterator<Object> iterator = llamadas.iterator(); iterator
				.hasNext();) {
			Llamada llamada = (Llamada) iterator.next();
			empresas = this.empresaDAO.buscarEmpresaPorNombre(llamada
					.getEmpresa());
			empresa = empresas.get(0);
			
			
			String cadena[]= llamada.getFechaVenta().split("/");
			String nueva = cadena[2] + "-" + cadena[1] + "-" + cadena[0];
			
			
			audio = new Audio(empresa.getCodEmpresa(), llamada.getDniCliente(),
					llamada.getApellidoPaternoCliente(), llamada
							.getApellidoMaternoCliente(), llamada
							.getNombresCliente(), llamada.getTelefonoCliente(),
							Timestamp.valueOf(nueva + " " +  llamada.getHoraVenta()), llamada.getDniAsesor(), llamada.getProceso(), llamada
							.getVdn(), llamada.getSkill(), llamada
							.getRutaAudio(), Util.getDateTimeStamp(), Util.getDateTimeStamp(),
					nombreUsuario, nombreUsuario);
			this.audioDAO.guardarAudio(audio);
		}

	}

	public List<Audio> buscarAudios(Audio audio,Integer firstIndex , Integer maxNumber) {
		return this.audioDAO.buscarAudios(audio, firstIndex, maxNumber);
	}

	
	public int buscarContarAudios(Audio audio) {
		return this.audioDAO.buscarContarAudios(audio);
	}

	

}
