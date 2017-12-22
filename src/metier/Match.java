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
	private ArrayList<Ville> listeVille= new ArrayList<Ville>();
	int codeDepartement;
	int b;
	int c;
	Scanner sc = new Scanner(System.in);
	
	public int departementChoisi() {
		System.out.println("Sélectionnez votre code de département");
		codeDepartement = Integer.parseInt(sc.nextLine());
		return codeDepartement;
	}

	@Override
	public ArrayList<Ville> selectionVille(int a, int b, int c, String d) {
		listeVille.addAll(dao.select(new Ville(a,b,c,d)));
		return listeVille;
	}
	
}
