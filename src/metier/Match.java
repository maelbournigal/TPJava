package metier;

import java.util.ArrayList;

import entitee.Ville;

public class Match implements IMatch{
	private ArrayList<Ville> listeVille= new ArrayList<Ville>();
	
	
	public int departementAlea() {
		int a = 5;
		return a;
	}
	public int arrondissementAlea() {
		int b = 5;
		return b;
	}
	public int cantonAlea() {
		int c = 6;
		return c;
	}
	
	
}
