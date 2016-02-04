package applis;

import platform.Iafficheur;
import platform.Personne;
import platform.Platform;

public class appli {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iafficheur aff = (Iafficheur) Platform.getInstance().getExtension(Iafficheur.class);
		Personne p = new Personne();
		aff.affiche(p);

	}

}
