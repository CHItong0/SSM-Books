package com.qf.zlp.realm;
import com.qf.zlp.mapper.UserMapper;
import com.qf.zlp.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;


@Component
/*继承AuthenticatingRealm*/
public class DbaRealm extends AuthorizingRealm {


   @Autowired
    UserMapper userMapper;
    /*存储查询出的用户信息用于查询*/

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        /*获取用户登录时输入的用户名*/
        String username = usernamePasswordToken.getUsername();
        //根用户名去查数据库
        User user = userMapper.SelectUser(username);

        //判断用户名是否为空
        if (user == null) {
            //如果为空说明写错了
            throw new UnknownAccountException("用户名输入错误");
        }

        //1.用户登录的用户名
        //2.用户的密码，这个密码为数据库查询出来的密码，此处为模拟；
        //3.这里返回之后，系统会自动根据这里返回的信息，再结合用户登录时输入的用户名密码信息去判断密码是否正确
        //获取密码的盐，我们这里是使用用户名作为 盐字段
        ByteSource salt = ByteSource.Util.bytes(user.getUname());
        return new SimpleAuthenticationInfo(user.getUname(),user.getUpassword(),salt,getName());
    }


    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");
        //设置密码计算的迭代次数
        matcher.setHashIterations(1024);
        return matcher;
    }
    /*
    * 当需要判断当前用户具有那些权限的时候，系统会自动调用当前方法来获取当前登录用户的权限；
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("============================");
        /*
        * 集合是因为，一个用户可能有多个权限
        *强转为当前用户名
        *  */
       String username= (String) principalCollection.getPrimaryPrincipal();
        /*判断权限
        默认为判断角色*/
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        /*创建集合接受数据库查询的结果
        * */
        Set<String> parmissions= userMapper.getUserPermissionsByUsername(username);

        /*数据库查询结果返回回来
          把查到的权限给SimpleAuthorizationInfo设置一个权限
        * */
        simpleAuthorizationInfo.setStringPermissions(parmissions);
        /*把结果返回给调用方

        * */

        Set<String> userRname = userMapper.getUserRname(username);
        simpleAuthorizationInfo.setRoles(userRname);



        return simpleAuthorizationInfo;
    }
}
