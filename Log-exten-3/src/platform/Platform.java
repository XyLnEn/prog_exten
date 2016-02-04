package platform;

import java.lang.reflect.Proxy;

import ressources.AfficheurDefault;

public class Platform {

	private static final Platform instance = new Platform();
	
	public Object getExtension(Class<?> interf) {
		Object target = new AfficheurDefault();
		Class[] interfaces = new Class[2];
		interfaces[0] = interf;
		interfaces[1] = Ilogged.class;
		Object proxy = Proxy.newProxyInstance(interf.getClassLoader(), interfaces , new LogHandler(target));
		return proxy;
		
	}

	public static Platform getInstance() {
		return instance;
	}
	

}
