package com.etc._06Task;
/**
 * 
 * @author Administrator
 *
 */

public class StringUtil {
           
	 private StringUtil(){
		 
	 }
	public static boolean haslength(String str){
		if(str!=null&&!"".equals(str.trim())){
			return true;
		}return false;
	}
}
