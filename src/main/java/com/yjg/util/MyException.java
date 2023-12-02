package com.yjg.util;
/**
 * 
 * @Title: MyException.java 
 * @Package com.yjg.util 
 * @Description:自定义异常  
 * @author YJG  
 * @date 2017年3月10日 下午2:23:40 
 * @version V1.0
 */
public class MyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	 public MyException()  {}                	  //用来创建无参数对象
	 public  MyException(String message) {        //用来创建指定参数对象
		 super(message);                          //调用超类构造器  
	 }
	 
	 public  MyException(Throwable e) {           //用来创建指定参数对象
		 super(e);                                //调用超类构造器  
	 }
}
