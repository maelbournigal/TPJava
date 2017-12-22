package metier;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
	ArrayList<Ville> listeGagnant= new ArrayList<Ville>();
	ArrayList<Ville> listePerdant= new ArrayList<Ville>();
	int vainqueur;
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
			System.out.println( i + " " + ville.getVilleNom());
			i++;
			listeVille.add(ville);
		}
		return listeVille;
	}
	public void combat(int i, int j) {
		int score1 = (int) ((listeVille.get(i).getVillePopulation()*listeVille.get(i).getVilleLatitude()*Math.random()*100)/listeVille.get(i).getVilleNom().length());
		int score2 = (int) ((listeVille.get(j).getVillePopulation()*listeVille.get(j).getVilleLatitude()*Math.random()*100)/listeVille.get(j).getVilleNom().length());
		
		if (score1>score2) {
			vainqueur = i;
			listeGagnant.add(listeVille.get(i));
			listePerdant.add(listeVille.get(j));
			}
		else {
			vainqueur = j;
			listeGagnant.add(listeVille.get(j));
			listePerdant.add(listeVille.get(i));
		}
		System.out.println(listeVille.get(i).getVilleNom() + " : " + score1 + " " + listeVille.get(j).getVilleNom() + " : " + score2);
		System.out.println("Le vainqueur est : " + listeVille.get(vainqueur).getVilleNom());
		if (i>j) {
			listeVille.remove(i);
			listeVille.remove(j);
		}
		else {
			listeVille.remove(j);
			listeVille.remove(i);
		}
		
	}
	public void tournois() {
		int x = listeVille.size();
		while(x >0) {
			x = listeVille.size();
			int ville1 = (int)(Math.random()*(x));
			int ville2 = (int) (Math.random()*(x));
			if (ville1 == ville2 && x != 0) {
				while(ville1 == ville2) {
					ville2 = (int)(Math.random()*(x) );
				}
			}
			combat(ville1,ville2);
		}
	}
}
