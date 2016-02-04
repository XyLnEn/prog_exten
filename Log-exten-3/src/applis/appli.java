package applis;

import platform.Platform;
import ressources.Iafficheur;
import ressources.Personne;

public class appli {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iafficheur aff = (Iafficheur) Platform.getInstance().getExtension(Iafficheur.class);
		Personne p = new Personne();
		aff.affiche(p);
		//aff.logOn();
		aff.affiche(p);
	}

}
