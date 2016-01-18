package sys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FactoryAffichageConcrete implements FactoryAffichage{

	
	public Iafficheur loadIafficheur() {
		BufferedReader br;
		Iafficheur affich;
		try {
			br = new BufferedReader(new FileReader("node.txt"));
			Class aff = Class.forName(br.readLine());
			affich = (Iafficheur)aff.newInstance();
		} catch (Exception e) {
			affich = null;
		}
		return affich;
	}
}
