package donnee;

import java.sql.Connection;
import java.util.ArrayList;

import entitee.Ville;

public interface IVilleDAO {
	public ArrayList<Ville> find(int idDepartement,int idCanton,int idArrondissement);
}