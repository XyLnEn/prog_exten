package sys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.sun.org.apache.bcel.internal.generic.LoadInstruction;

public class Appli {

	private static Iafficheur affichage;
	private static FactoryAffichage factAff;
	
	public static FactoryAffichage getFactAff() {
		if(factAff == null) {
			synchronized(FactoryAffichage.class) {
				if(factAff == null) {
					factAff = new FactoryAffichageConcrete();
				}
			}
		}
		return factAff;
	}
	
	public static void main(String[] args) throws Exception {
		
		affichage = getFactAff().loadIafficheur();
		Personne p = new Personne();
		p.setNom("todo");
		while(true) {
			affichage.affiche(p);
			affichage = getFactAff().loadIafficheur();
		}
	}
}
