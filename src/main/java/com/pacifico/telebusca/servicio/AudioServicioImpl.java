package com.pacifico.telebusca.servicio;

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

	public void guardarAudio(List<Object> llamadas, String nombreUsuario) {	
		Audio audio;
		List<Empresa> empresas;
		Empresa empresa;
		for (Iterator<Object> iterator = llamadas.iterator(); iterator
				.hasNext();) {
			Llamada llamada = (Llamada) iterator.next();
			empresas = this.empresaDAO.buscarEmpresaPorNombre(llamada
					.getEmpresa());
			empresa = empresas.get(0);
			audio = new Audio(empresa.getCodEmpresa(), llamada.getDniCliente(),
					llamada.getApellidoPaternoCliente(), llamada
							.getApellidoMaternoCliente(), llamada
							.getNombresCliente(), llamada.getTelefonoCliente(),
					null, llamada.getDniAsesor(), llamada.getProceso(), llamada
							.getVnd(), llamada.getSkill(), llamada
							.getRutaAudio(), Util.getDate(), Util.getDate(),
					nombreUsuario, nombreUsuario);
			this.audioDAO.guardarAudio(audio);
		}

	}

	public List<Audio> buscarAudios(Audio audio, String start_date,
			String end_date) {
		return this.audioDAO.buscarAudios(audio, start_date, end_date);
	}

}
