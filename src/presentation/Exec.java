package presentation;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entitee.Ville;
import metier.IMatch;

public class Exec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		IMatch m = (IMatch) context.getBean("match");
		
		ArrayList<Ville> listeVilleMatch = m.selectionVille(a, b, c, d);
		System.out.println(listeVilleMatch);

	}

}
