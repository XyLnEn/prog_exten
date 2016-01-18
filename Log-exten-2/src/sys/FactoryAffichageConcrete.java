package sys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class FactoryAffichageConcrete implements FactoryAffichage{

	
	public Iafficheur loadIafficheur() {
		BufferedReader br;
		int i = 0;
		String s;
		Vector<Class> listeClass = new Vector<Class>();
		//Vector<String> listeNom = new Vector<String>();
		Iafficheur affich;
		try {
			br = new BufferedReader(new FileReader("node.txt"));
			while((s= br.readLine()) != null) {
				listeClass.add(Class.forName(s.split(":")[0]));
				System.out.println(s.split(":")[1]);
				
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("lequel?");
			i = sc.nextInt();
			affich = (Iafficheur)listeClass.get(i).newInstance();
		} catch (Exception e) {
			affich = null;
		}
		return affich;
	}
}
