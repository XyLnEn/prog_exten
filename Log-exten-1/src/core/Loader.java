package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class Loader {
	
	public static void main(String[] args) throws Exception{
		String line = "";
		String temp = "";
		BufferedReader buff = new BufferedReader(new FileReader("bean.txt"));
		
		line = buff.readLine();
		
		Class<?> cl = Class.forName(line.split("=")[1]);
		
		Object obj =null;
		while((line = buff.readLine()) != null) {
			obj = cl.newInstance();
			temp = "set" + line.split("=")[0];
			Method m1 = cl.getMethod(temp, String.class);
			m1.invoke(obj, line.split("=")[1]);
			
			line = buff.readLine();
			temp = "set" + line.split("=")[0];
			Method m2 = cl.getMethod(temp, String.class);
			m2.invoke(obj, line.split("=")[1]);
			
			Method m3 = cl.getMethod("toString");
			System.out.println(m3.invoke(obj));
		}
		
	}
	
}
