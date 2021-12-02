package testMvcDemo.jdkCglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import testMvcDemo.proxy.User;
import testMvcDemo.proxy.UserService;
import testMvcDemo.proxy.UserServiceImpl;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
        // 1. 创建原始对象
        UserServiceImpl userService = new UserServiceImpl() ;

        /*
         2. 通过 cglib 方式创建动态代理对象
         对比 jdk 动态代理 ---> Proxy.newProxyInstance(classLoader, interface, invocationHandler);

         Enhancer.setClassLoader()
         Enhancer.setSuperClass()
         Enhancer.setCallBack() ---> MethodInterceptor(cglib)
         Enhancer.createProxy() ---> 创建代理对象
         */
        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("--- cglib log ----");
                Object ret = method.invoke(userService, args); // 执行原始方法
                return ret;
            }
        };

        enhancer.setCallback(interceptor);
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("zhenyu", "123456");
        userServiceProxy.register(new User());
    }
}
/*
--- cglib log ----
        UserServiceImpl.login 业务运算 + DAO
        --- cglib log ----
        UserServiceImpl.register 业务运算 + DAO*/
