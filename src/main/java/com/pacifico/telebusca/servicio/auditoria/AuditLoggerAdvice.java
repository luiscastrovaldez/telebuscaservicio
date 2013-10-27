package com.pacifico.telebusca.servicio.auditoria;


import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.dao.AudSistemaDAO;

@Service("auditLoggerAdvice")
public class AuditLoggerAdvice {
	
	
	@Autowired
	private AudSistemaDAO audSistemaDAO;
	
	public void auditoria(JoinPoint call) throws Throwable{
		/*
		String action = getMethodSignature(call);	
		
		System.out.println("action " + action);	
		
		Object [] args = call.getArgs();
		if (args != null){
			System.out.println("args " + args[0]);	
		}
		
		
		/*
		//Se obtiene el username
		String user = getCurrentUser();			
		
		//Se guarda el registro en la tabla de auditoria
		logAudit(action,args,user);					
		System.out.println("Auditado!\nmetodo ->" +action+"\nparams -> "+stringArgs+"\nusuario -> "+user);
		
		//Se Invoca explicitamente el método destino
		//return call.proceed();
		*/
	}

	private String getMethodSignature(JoinPoint call) {
		String fullSignature = call.getSignature().toLongString();
		String[] methodSignatureParts = fullSignature.split(" ");
		String part = null;
		
		for (int i = methodSignatureParts.length - 1; i >= 0; i--) {
			part = methodSignatureParts[i];
			if (part.indexOf("(") > 0) {
				break;
			}
			
		}
		return part;
	}


}
