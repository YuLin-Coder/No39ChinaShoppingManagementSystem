package com.yjg.util;
/**
 * 
 * @Title: MyException.java 
 * @Package com.yjg.util 
 * @Description:�Զ����쳣  
 * @author YJG  
 * @date 2017��3��10�� ����2:23:40 
 * @version V1.0
 */
public class MyException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	 public MyException()  {}                	  //���������޲�������
	 public  MyException(String message) {        //��������ָ����������
		 super(message);                          //���ó��๹����  
	 }
	 
	 public  MyException(Throwable e) {           //��������ָ����������
		 super(e);                                //���ó��๹����  
	 }
}
