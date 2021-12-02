package testMvcDemo.jdkCglibProxy;

import testMvcDemo.proxy.User;
import testMvcDemo.proxy.UserService;
import testMvcDemo.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    /**
     1. 借⽤类加载器  TestJDKProxy 或 UserServiceImpl 都可以
     2. JDK8.x 前必须加 final
     final UserService userService = new UserServiceImpl();
     */
    public static void main(String[] args) {
        // 1. 创建原始对象
        UserService userService = new UserServiceImpl();

        // 2. JDK 动态代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---- proxy log ----");
                // 原始方法运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.
                newProxyInstance(TestJDKProxy.class.getClassLoader(),
                                userService.getClass().getInterfaces(),
                                handler);
        userServiceProxy.login("zhenyu", "123456");

        userServiceProxy.register(new User());
    }
}

/*---- proxy log ----
        UserServiceImpl.login 业务运算 + DAO
        ---- proxy log ----
        UserServiceImpl.register 业务运算 + DAO*/
