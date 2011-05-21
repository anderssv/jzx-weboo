package no.f12.jzx.weboo.testutil;

public class BeansUtil {

	@SuppressWarnings("all")
	public static String beanName(Class clazz) {
		String name = clazz.getSimpleName();
		String beanName = name.substring(0, 1).toLowerCase() + name.substring(1);
		return beanName;
	}

}
