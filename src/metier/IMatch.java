package metier;

import java.util.ArrayList;

import entitee.Ville;

public interface IMatch {
	public int departementChoisi();
	public int arrondissementChoisi();
	public int cantonChoisi();
	public ArrayList<Ville> villesChoisis();
	public void combat(int i, int j);
	public void tournois();
}
