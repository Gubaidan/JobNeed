package Proxy;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String id, String passward) {
		System.out.println("addUser");
		
	}

	@Override
	public void delUser(String id) {
		System.out.println("delUser");
	}

}
