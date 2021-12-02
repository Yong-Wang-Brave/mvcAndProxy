package testMvcDemo.staticProxy;

public interface UserService {
	void register(User user);
	boolean login(String name, String password);
}
