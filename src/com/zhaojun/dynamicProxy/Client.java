package com.zhaojun.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args){
	    //����Ҫ�������ʵ����
	    Subject realObject = new RealObject();
	
	    //����DynamicProxy������Ķ���
	    InvocationHandler handler = new DynamicProxy(realObject);
	
	    /*
	     * ͨ��Proxy��newProxyInstance�������������ǵĴ������(�������realObject�������������ͬ)����������������������
	     * ��һ������ handler.getClass().getClassLoader() ����������ʹ��handler������ClassLoader�������������ǵĴ������
	     * �ڶ�������realSubject.getClass().getInterfaces()����������Ϊ��������ṩ�Ľӿ�����ʵ������ʵ�еĽӿڣ���ʾ��Ҫ������Ǹ���ʵ���������Ҿ��ܵ�������ӿ��еķ�����
	     * ����������handler�� �������ｫ������������������Ϸ��� InvocationHandler ���������
	     */
	    Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realObject
	            .getClass().getInterfaces(), handler);
	    
	    System.out.println(subject.getClass().getName());
	    subject.rent();
	    subject.hello("world");
	}
}
