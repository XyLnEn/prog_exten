package aff;

import sys.Iafficheur;
import sys.Personne;

public class AfficheurPresqueJoli implements Iafficheur {

	public void affiche(Personne p) {
		String s = "*" + p.getNom() + " , " + p.getPrenom() + "*";
		String t = "";
		int taille = s.length();
		for(int i = 0; i< taille; ++i) {
			t += '*';
		}
		System.out.println(t);
		System.out.println(s);
		System.out.println(t);
	}
}
