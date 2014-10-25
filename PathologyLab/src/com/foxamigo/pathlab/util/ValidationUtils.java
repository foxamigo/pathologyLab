package com.foxamigo.pathlab.util;

public class ValidationUtils {

	public static boolean isEmpty(String string){
		if("".equalsIgnoreCase(string)){
			return true;
		}
		return false;
	}
}
