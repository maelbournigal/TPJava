package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import connection.Connect;
import entitee.Ville;

@Component(value="ville")
public class VilleDAO implements IVilleDAO{
	ArrayList<Ville> listeVille= new ArrayList<Ville>();
	Connect connect = new Connect();
	
	public ArrayList<Ville> find(int idDepartement, int idCanton, int idArrondissement) {
		
		
		connect.Connection();
		//requete a la base de donée
				String requete  = "SELECT * from villes_france_free where ville_departement = " + idDepartement + " && ville_arrondissement = " + idArrondissement + " && ville_canton = " + idCanton;
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = connect.con.createStatement();
					rs = stmt.executeQuery(requete);
				} catch (SQLException e) {
					System.out.println("Anomalie lors de l'execution de la requête");
				}
				try {
					//recuperation des données pour creer objet ville
					while (rs.next()) {
						Ville ville = new Ville(rs.getInt("ville_departement"), rs.getInt("ville_arrondissement"), rs.getInt("ville_canton"), rs.getString("ville_nom"), rs.getInt("ville_population_2012"), rs.getInt("ville_latitude_deg"));
						//ajout a listeVille
						listeVille.add(ville);
						
					}
				} catch (SQLException e) {
					System.out.println("problème SQL");
				}
				connect.Close();
		    return listeVille;
	}
	/*public void insert() {
		for (Ville ville : listeVille) {

			// insert bdd
			String requete2  = "INSERT INTO match_ville (ville_nom, ville_population, ville_latitude) VALUES ( '" + ville.getVilleNom() + "' , '" + ville.getVillePopulation() + "', '" + ville.getVilleLatitude() + "')";
			Statement stmt2 = null;

			try {
				stmt2 = connect.con.createStatement();
				int nbrMaj  = stmt2.executeUpdate(requete2);
				System.out.println(nbrMaj);
			} catch (SQLException e) {
				System.out.println("Anomalie lors de l'insert");
			}
		}
	}*/
}