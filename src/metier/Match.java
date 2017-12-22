package metier;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import donnee.IVilleDAO;
import entitee.Ville;

@Component(value="match")
public class Match implements IMatch{
	@Autowired
	IVilleDAO dao;
	int a;
	int b;
	int c;
	String nomVille;
	Scanner sc = new Scanner(System.in);
	
	public int departementChoisi() {
		System.out.println("Sélectionnez votre code de département");
		a = Integer.parseInt(sc.nextLine());
		return a;
	}
	public int arrondissementChoisi() {
		System.out.println("Sélectionnez votre code arrondissement");
		b = Integer.parseInt(sc.nextLine());
		return b;
	}
	public int cantonChoisi() {
		System.out.println("Sélectionnez votre code de canton");
		c = Integer.parseInt(sc.nextLine());
		return c;
	}

	@Override
	public void villesChoisis() {
		departementChoisi();
		arrondissementChoisi();
		cantonChoisi();

		for (Ville ville : dao.find(a, b, c) ) {
			System.out.println(ville.getVilleNom()+ "test");;
		}
}
	
}
