package br.com.valmirjunior.gradbook.util;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

public class FacesUtil {
	private static String msg_successful_operation=MessageUtil.getValue("successful_operation");
	private static String msg_successful_register=MessageUtil.getValue("successful_register");
	private static String msg_successful_update=MessageUtil.getValue("successful_update");
	private static String msg_successful_delete=MessageUtil.getValue("successful_delete");

	public static void showInfoMessage(String title, String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,title, message);		
		RequestContext.getCurrentInstance().showMessageInDialog(facesMessage);	
	}
	
	public static void showCreateRegisterMessage() {
		showInfoMessage(msg_successful_operation, msg_successful_register);
	}
	
	public static void showUpdateRegisterMessage() {
		showInfoMessage(msg_successful_operation, msg_successful_update);
	}
	
	public static void showDeleteRegisterMessage() {
		showInfoMessage(msg_successful_operation, msg_successful_delete);
	}
	
	
}
