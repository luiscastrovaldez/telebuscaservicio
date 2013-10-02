package com.pacifico.telebusca.servicio.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.servicio.EmpresaServicio;

public class RmiCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:com/pacifico/telebusca/config/applicationContext-rmi.xml");
			System.out.println("empresaServicioRmi");
			EmpresaServicio empresaServicio = (EmpresaServicio) context
					.getBean("empresaServicioCliente");
			Empresa empresa = empresaServicio.buscarEmpresaPorCodigo(4);
			System.out.println("codigo " + empresa.getCodEmpresa());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
