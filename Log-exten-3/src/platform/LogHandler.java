package platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	public Object t;
	public boolean status;
	
	public LogHandler(Object t) {
		this.t = t;
		status = false;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("logOn")) {
			if (status == false) {
				System.out.println("ok, login activé");
				status = true;
			}
			return null;
		} else if(method.getName().equals("logOff")) {
			if (status == true) {
				System.out.println("ok, login desactivé");
				status = false;
			}
			return null;
		} else {
			if(status) {
				System.out.println("lol");
			}
			return method.invoke(t, args);
		}
	}

}
