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
	ArrayList<Ville> listeVille= new ArrayList<Ville>();
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
	public ArrayList<Ville> villesChoisis() {
		departementChoisi();
		arrondissementChoisi();
		cantonChoisi();
		int i = 0;
		for (Ville ville : dao.find(a, b, c) ) {
			i++;
			System.out.println( i + " " + ville.getVilleNom());
			listeVille.add(ville);
		}
		return listeVille;
	}
	public void combat(int i, int j) {
		int score1 = (int) ((listeVille.get(i).getVillePopulation()*listeVille.get(i).getVilleLatitude()*Math.random()*100)/listeVille.get(i).getVilleNom().length());
		int score2 = (int) ((listeVille.get(j).getVillePopulation()*listeVille.get(j).getVilleLatitude()*Math.random()*100)/listeVille.get(j).getVilleNom().length());
		System.out.println(listeVille.get(i).getVilleNom() + " : " + score1 + " " + listeVille.get(j).getVilleNom() + " : " + score2);
	}

}
