package com.pacifico.telebusca.servicio.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Rmi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/pacifico/telebusca/config/applicationContext.xml");
		System.out.println("context");
	}

}
