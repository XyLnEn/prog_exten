package sys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class FactoryAffichageConcrete implements FactoryAffichage{

	private Map<String, Iafficheur> map = new HashMap<String,Iafficheur>();
	
	public Iafficheur loadIafficheur() {
		BufferedReader br;
		int i;
		String templigne;
//		Vector<Class> listeClass = new Vector<Class>();
		Vector<String> listeClass = new Vector<String>();
		Iafficheur affich = null;
		try {
			br = new BufferedReader(new FileReader("node.txt"));
			while((templigne= br.readLine()) != null) {
				if(!templigne.split(":")[0].equals("#")) {
					listeClass.add(templigne.split(":")[1] + "!" + templigne.split(":")[3]);
					System.out.println(templigne.split(":")[0] + " : " + templigne.split(":")[2]);
				}
				else {
					System.out.println(templigne.split(":")[1]);
				}
				
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("lequel?");
			i = sc.nextInt();
			if((listeClass.get(i-1).split("!")[1]).equals("avec_singleton")) {
				if(map.containsKey(listeClass.get(i-1))) {
					System.out.println("pas de réinstantation, c'est un singleton!");
					return map.get(listeClass.get(i-1));
				}
				else {
					affich = (Iafficheur)Class.forName(listeClass.get(i-1).split("!")[0]).newInstance();
					map.put(listeClass.get(i-1), affich);
				}
			}
			else {
				affich = (Iafficheur)Class.forName(listeClass.get(i-1).split("!")[0]).newInstance();
			}
		} catch (Exception e) {
			affich = null;
		}
		return affich;
	}

	public Map getMap() {
		return map;
	}

	
}
