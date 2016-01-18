package sys;

public class AfficheurDefault implements Iafficheur {

	public void affiche(Personne p) {
		System.out.println(p.getNom() + " , " + p.getPrenom());
	}

}
