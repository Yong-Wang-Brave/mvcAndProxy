package testMvcDemo.proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testProxy {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("admin", "1234");
        userService.register(new User());
    }
/*---method before advice log---
    UserServiceImpl.login 业务运算 + DAO
---method before advice log---
    UserServiceImpl.register 业务运算 + DAO*/
}
