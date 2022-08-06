package com.qf.zlp.UserController;
import com.qf.zlp.model.*;
import com.qf.zlp.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class UserController {
  @Autowired
    UserService userService;
  @Autowired
    BookService bookService;

  @Autowired
    AuthorService authorService;

  @Autowired
    TypesService typesService;

  @Autowired
    BookAuthorService bookAuthorService;

  @Autowired
  BookTypesService bookTypesService;

  @Autowired
  UserBookService userBookService;

    /*跳转登录页面*/
   @RequestMapping("/login")
    public String showif(){

        return "/login";
    }
    /*登录接口*/
   @PostMapping("/doLogin")
    public String showif01(String uname, String password, Model model, String rememberMe, HttpSession session){
        //Realm返回的结果
        Subject subject = SecurityUtils.getSubject();
        //自定义 Realm类传入数据 Realm底层会调用
        UsernamePasswordToken token= new UsernamePasswordToken(uname,password);
       User user = userService.SelectUser(token.getUsername());
       session.setAttribute("user",user);

            //执行登录逻辑
        try {
            // on 为前端传递的单选框值  rememberMe
            if ("on".equals(rememberMe)) {
                token.setRememberMe(true);
            }
            subject.login(token);




            return "redirect:/allBook";
        } catch (AuthenticationException e) {
          e.printStackTrace();
            /*如果出错往前端发送*/
            model.addAttribute("error",e.getMessage());
        }
        //登录失败就前往登录页面
        return "forward:/login";
    }
    /*跳转注册接口*/
    @RequestMapping("/register")
    public String register(){

       return "register";
    }
/*去注册*/
    @PostMapping("/doRegister")
    public String doregister(User user,Model model){


            User user1 = userService.SelectUser(user.getUname());
            /*如果为空*/
            if (user1 != null) {
                model.addAttribute("msg", "用户名重复");
                return "forward:register";
            }
            if (user1 == null) {
                String uname = user.getUname();
                String password = user.getUpassword();
                String email = user.getEmail();
                String phone = user.getPhone();
                Md5Hash md5Hash = new Md5Hash(password, uname, 1024);
                String s = md5Hash.toString();
                User user2 = new User();
                user2.setUname(uname);
                user2.setUpassword(s);
                user2.setEmail(email);
                user2.setPhone(phone);
                userService.addUser(user2);



                return "redirect:/login";
            }

        return "register";
    }

    @RequestMapping("/UserPermission")
    public String UserPermission(Model model){

        List<UserPermission> UserPermission = userService.selectUserPermission();


        model.addAttribute("UserPermission",UserPermission);

        return "permission";
    }

    @RequestMapping("/UserPermissions")
    public String selectUserPermission(Model model){


        return null;
    }















}
