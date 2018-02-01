package Proxy;

public class TestJDKProxy {
	
	public static void main(String args[]) {
		JDKProxy jdkProxy = new JDKProxy();
		UserManager userManager = (UserManager) jdkProxy.newProxy(new UserManagerImpl());
		userManager.addUser(" ", " ");
	} 

}
