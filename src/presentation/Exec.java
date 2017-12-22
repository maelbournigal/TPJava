package presentation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMatch;

public class Exec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		IMatch m = (IMatch) context.getBean("match");
		m.villesChoisis();
		m.tournois();
	}

}
