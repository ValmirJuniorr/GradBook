package br.com.valmirjunior.gradbook.util;

import java.util.ResourceBundle;

public class MessageUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle("Bundle");

	public static String getValue(String key) {
		try {			
			return bundle.getString(key);			
		} catch (Exception e) {
			return "erro ao processar resposta a chave "+" � inv�lida ou o resource n�o pode ser inicializado";
		}
	}

}
