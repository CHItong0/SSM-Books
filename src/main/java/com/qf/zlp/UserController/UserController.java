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
import org.springframework.web.bind.annotation.RequestParam;

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

    /*跳转登录页面*/
   @RequestMapping("/login")
    public String showif(){

        return "/login";
    }
    /*登录接口*/
   @PostMapping("/doLogin")
    public String showif01(String uname, String password, Model model,String rememberMe){
       System.out.println("username"+ uname);
       System.out.println("password"+password);
       System.out.println(rememberMe);
        //Realm返回的结果
        Subject subject = SecurityUtils.getSubject();
        //自定义 Realm类传入数据 Realm底层会调用
        UsernamePasswordToken token= new UsernamePasswordToken(uname,password);
            //执行登录逻辑
        try {
            // on 为前端传递的单选框值  rememberMe
            if ("on".equals(rememberMe)) {
                token.setRememberMe(true);
            }
            subject.login(token);
            /*跳转到hello方法*/
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
    public String doregister(String uname, String password,Model model){
        System.out.println(uname+password);
        User user1 = userService.SelectUser(uname);
        /*如果为空*/
            if (user1!=null) {
                String uname1 = user1.getUname();
                model.addAttribute("msg","用户名重复");
                return "forward:register";
            }
            if (user1==null){
                Md5Hash md5Hash = new Md5Hash(password, uname, 1024);
                String s = md5Hash.toString();
                System.out.println(md5Hash);
                User user = new User();
                user.setUname(uname);
                user.setUpassword(s);
                userService.addUser(user);
                return "redirect:/login";
            }
        return "register";
    }
    /* 主页显示所有*/
    @RequestMapping("/allBook")
    public String allBook(Model model, @RequestParam(value = "currPage",defaultValue = "1") int currPage, @RequestParam(value = "size" ,defaultValue = "5") int size){



        List<Books> fallback = userService.Allbook();
        if (fallback!=null){
            model.addAttribute("fallback",fallback);
            return "index";
        }
        return "/login";
    }


    /*订阅书 */
    @RequestMapping("/Lookbooks")
    public String Lookbooks(Model model,int id){
        return "redirect:allBook";
    }

    /* 主页模糊查询*/
    @RequestMapping("/queryBookByName")
    public String queryBookByName(String name,Model  model){
            List<Books> fallback = bookService.likeBooks(name);
            assert fallback!=null;
            if (fallback.isEmpty()){
                model.addAttribute("error","没有查询到");
            }else {
                model.addAttribute("fallback",fallback);
            }
        return "index";
    }
    //去修改的接口
    @RequestMapping("/toUpdateBook")
    public  String toUpdateBook(Model model,int id){
        Books books = userService.selectbooksbyid(id);
        model.addAttribute("books",books);
        return "updateBook";
    }
    //修改接口
    @RequestMapping("/updateBook")
    public String updateBook(int bookId,String bookName,String bookBdescribe,String bookAname,String bookTname){
        /*修改book表*/
        Book book = new Book();
        book.setBid(bookId);
        book.setBname(bookName);
        book.setBdescribe(bookBdescribe);
        bookService.UpdateBook(book);
        /*根据作者名，查作者*/
        Author author3 = new Author();
        author3.setAname(bookAname);
        Author author = authorService.selectAuthor(author3);
        /*作者不存在去增加一个作者*/
        if (author==null){
            Author author1 = new Author();
            author1.setAname(bookAname);
             authorService.addAuthor(author1);
        }
        /*根据作者去数据库查询作者*/
        Author author1 = new Author();
        author1.setAname(bookAname);
        Author author2 = authorService.selectAuthor(author1);
        /*判断作者是否存在*/
        if (bookAname.equals(author2.getAname())){
            /*查作者与书本中间表*/
            List<BookAuthor> bookAuthors = bookAuthorService.selectBookAutor(bookId);
            Integer aid1 = null;
            for (BookAuthor book1:bookAuthors){
              aid1=   book1.getAid();
            }
            /*根据qian'duan*/
            Book book2 = new Book();
            book2.setBid(bookId);
            Book book1 = bookService.selectBookname(book2);
            System.out.println(book1);
            if (book1!=null&& aid1!=null){
                Integer bid = book1.getBid();
                /*更改中间表对应关系*/
                /*根据前端传入修改的作者查询id 修改中间表的id*/
                Integer aid2 = author2.getAid();
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setAid(aid2);
                bookAuthor.setBid(bid);
                bookAuthorService.UpdateBookAutor(bookAuthor);
            }
        }
        /*查询书本类型*/
        Types types2 = new Types();
        types2.setTname(bookTname);
        Types types = typesService.selectTypes(types2);
        //查询书本类型为空，增加一个书本类型
        if (types==null){
            Types types1 = new Types();
            types1.setTname(bookTname);
            typesService.AddTypes(types1);
        }
        //查询书本类型
        Types types3 = new Types();
        types3.setTname(bookTname);
        Types types1 = typesService.selectTypes(types3);
        //判断前端传入的书本类型是否在数据库中
        if (bookTname.equals(types1.getTname())){
            //查询中间表
            List<BookTypes> bookTypes = bookTypesService.AllBookTypes();
            Integer tid=null;
            //遍历中间表
            for (BookTypes bookTypes1:bookTypes){
                tid = bookTypes1.getTid();
            }
            Book book2 = new Book();
            book2.setBid(bookId);
            Book book1 = bookService.selectBookname(book2);
            if (book1!=null&&tid!=null){
                Integer bid = book1.getBid();
                Integer tid1 = types1.getTid();
                BookTypes bookTypes1 = new BookTypes();
                bookTypes1.setTid(tid1);
                bookTypes1.setBid(bid);
                bookTypesService.UpDateBookType(bookTypes1);
            }
        }

        return "redirect:allBook";
    }

    @RequestMapping("/addbook")
    public String addbook(){

        return "addBook";
    }
    @RequestMapping("/addBooks")
    public String addBooks (Book book,Author author,Types types){

        bookService.AddBook(book);

        System.out.println("book = " + book);

        authorService.selectAuthor(author);

        System.out.println("author = " + author);
        typesService.selectTypes(types);

        System.out.println("types = " + types);

        authorService.selectAuthor(author);

        System.out.println("author = " + author);

        typesService.AddTypes(types);
        //根据上面查询插入的书名跟书详情

        Book book2 = bookService.selectBookname(book);
        //根据上面查询插入的作者

        Author author2 = authorService.selectAuthor(author);

        //根据上面查询插入的书本类型

        Types types2 = typesService.selectTypes(types);

        //插入书本作者与中间表联系
        if (book2!=null&&author2!=null){
            Integer bid = book2.getBid();
            Integer aid = author2.getAid();
            BookAuthor bookAuthor1 = new BookAuthor();
            bookAuthor1.setAid(aid);
            bookAuthor1.setBid(bid);
            bookAuthorService.AdddBookAutoraid(bookAuthor1);
        }
        //插入书本表与类型中间表联系
        if (book2!=null&&types2!=null){
            Integer bid = book2.getBid();
            Integer tid = types2.getTid();
            BookTypes bookTypes1 = new BookTypes();
            bookTypes1.setTid(tid);
            bookTypes1.setBid(bid);
            bookTypesService.AddBookTypes(bookTypes1);
        }


        return "redirect:allBook";
    }













}
