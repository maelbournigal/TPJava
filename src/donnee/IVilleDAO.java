package donnee;

import java.util.Collection;

import entitee.Ville;

public interface IVilleDAO {
	public Collection<? extends Ville> select(Ville c);
}
