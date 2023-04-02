package com.qf.zlp.realm;

import com.qf.zlp.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
/*继承AuthenticatingRealm*/
public class MyRealm extends AuthenticatingRealm {

    /*存储查询出的用户信息用于查询*/

   Map<String,User> userMap =new HashMap<>();

    public MyRealm() {

        User user = new User();
        user.setUname("hi");
        user.setUpassword("418814");
        userMap.put("hi",user);

        User user1 =new User();
        user1.setUname("hello");
        user1.setUpassword("123456");
        userMap.put("hello",user1);


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        /*获取用户登录时输入的用户名*/

        String username = usernamePasswordToken.getUsername();

        //根用户名去查数据库，此处这个数据是写死的 用于模拟
        User user = userMap.get(username);
        System.out.println(user);



        //判断用户名是否为空
        if (user == null) {
            //如果为空说明写错了
            throw new UnknownAccountException("用户名输入错误");
        }
        //1.用户登录的用户名
        //2.用户的密码，这个密码为数据库查询出来的密码，此处为模拟；
        //3.这里返回之后，系统会自动根据这里返回的信息，再结合用户登录时输入的用户名密码信息去判断密码是否正确
        return new SimpleAuthenticationInfo(user.getUname(),user.getUpassword(),getName());
    }
}
