package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResourseBundling {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("1. Marathi\n2. US English \n3. UK English\n4. France\nEnter Choice:  ");
		choice=sc.nextInt();
		MessageSource ms=(MessageSource) ctx.getBean("messageSource");
		String m=null, w=null, d=null, c=null;
		Locale locale=null; 
		
		switch(choice) {
		case 1:
			locale = new Locale("marathi","IN");
			System.out.println("Language: "+locale.getLanguage()+" Country: "+locale.getCountry());
			break;
		case 2:
			locale = Locale.US;
			System.out.println("Language: "+locale.getLanguage()+" Country: "+locale.getCountry());
			break;
		case 3:
			locale = Locale.UK;
			System.out.println("Language: "+locale.getLanguage()+" Country: "+locale.getCountry());
			break;
		case 4:
			locale = Locale.FRANCE;
			System.out.println("Language: "+locale.getLanguage()+" Country: "+locale.getCountry());
			break; 
		default:
			System.out.println("Enter Valid Choice..!!");
			break;
		}
		
		m=ms.getMessage("msg.pay",null, locale);
		w=ms.getMessage("msg.welcome",new Object[] {"Varadraj"}, locale);
		d=ms.getMessage("msg.data",null, locale);
		c=ms.getMessage("msg.currency",null, locale);
		System.out.println("Pay: "+m);
		System.out.println("Welcome: "+w);
		System.out.println("Data: "+d);
		System.out.println("Currency: "+c);
	}

}
