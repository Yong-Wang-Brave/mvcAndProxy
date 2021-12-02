package testMvcDemo.staticProxy;

public class testStaticProxy {
    public static void main(String[] args) {
        UserServiceProxy up =new UserServiceProxy();
        up.login("wy","wy");

    }
/*    ---log---
    UserServiceImpl.login 业务运算 + DAO*/

}
