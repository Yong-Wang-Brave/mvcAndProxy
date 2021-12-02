package testMvcDemo.staticProxy;

/**
 * 静态代理类编码实现
 */
public class UserServiceProxy implements UserService { // 实现原始类相同的接口
    private UserService userService = new UserServiceImpl(); // 代理类中必须有原始类
    @Override
    public void register(User user) {
        System.out.println("---log---"); // 额外功能
        userService.register(user);
    }
    @Override
    public boolean login(String name, String password) {
        System.out.println("---log---"); // 额外功能
        return userService.login(name, password);
    }
}
