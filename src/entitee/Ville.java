package entitee;

public class Ville {
	private int id;
	private int idDepartement;
	private int idCanton;
	private int idArrondissement;
	private String villeNom;
	private int villePopulation;
	private int villeLatitude;
	
	public Ville() {}
	
	public Ville(int idDepartement, int idCanton, int idArrondissement, String villeNom, int villePopulation, int villeLatitude) {
		this.idDepartement = idDepartement;
		this.idCanton = idCanton;
		this.idArrondissement = idArrondissement;
		this.villeNom = villeNom;
		this.villePopulation = villePopulation;
		this.villeLatitude = villeLatitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	public int getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}

	public int getIdArrondissement() {
		return idArrondissement;
	}

	public void setIdArrondissement(int idArrondissement) {
		this.idArrondissement = idArrondissement;
	}

	public String getVilleNom() {
		return villeNom;
	}

	public void setVilleNom(String villeNom) {
		this.villeNom = villeNom;
	}

	public int getVillePopulation() {
		return villePopulation;
	}

	public void setVillePopulation(int villePopulation) {
		this.villePopulation = villePopulation;
	}

	public int getVilleLatitude() {
		return villeLatitude;
	}

	public void setVilleLatitude(int villeLatitude) {
		this.villeLatitude = villeLatitude;
	};
}
