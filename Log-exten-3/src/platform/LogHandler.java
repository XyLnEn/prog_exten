package platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	Object t;
	
	public LogHandler(Object t) {
		this.t = t;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("lol");
		return method.invoke(t, args);
	}

}
