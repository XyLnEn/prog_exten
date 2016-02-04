package platform;

import java.lang.reflect.Proxy;

public class Platform {

	private static final Platform instance = new Platform();
	
	public Object getExtension(Class<?> interf) {
		Object target = new AfficheurDefault();
		Class[] interfaces = {interf};
		Object proxy = Proxy.newProxyInstance(interf.getClassLoader(), interfaces , new LogHandler(target));
		return proxy;
		
	}

	public static Platform getInstance() {
		return instance;
	}
	

}
