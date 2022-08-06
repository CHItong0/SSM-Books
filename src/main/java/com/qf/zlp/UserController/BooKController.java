package com.qf.zlp.UserController;
import com.github.pagehelper.PageHelper;
import com.qf.zlp.model.*;
import com.qf.zlp.service.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BooKController {
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

    @Autowired
    UserService userService;
    /* 主页显示所有*/
    @RequestMapping("/allBook")
    public String allBook(Model model, HttpSession session){



        List<Books> booksList = userService.Allbook();
        System.out.println(booksList);
        if (booksList!=null){
            model.addAttribute("booksList",booksList);

            session.getAttribute("user");


            return "index";
        }

        return "/login";
    }


    /*订阅书 */
    @RequestMapping("/looKooks")
    public String Lookbooks(int id,HttpSession httpSession,Model model){



        User user = (User) httpSession.getAttribute("user");
        if (user!=null){

            Integer uid1 = user.getUid();

            UserBook userBook2 = new UserBook();
            userBook2.setUid(uid1);
            userBook2.setBid(id);
            UserBook userBook1 = userBookService.selectUserBook(userBook2);

            if (userBook1==null){
                Integer uid = user.getUid();
                UserBook userBook = new UserBook();
                userBook.setBid(id);
                userBook.setUid(uid);
                userBookService.AddUserbookByid(userBook);

                return "redirect:allBook";
            }

            model.addAttribute("error","请勿重复订阅");
            return "redirect:allBook";

        }
        return "redirect:allBook";
    }



    /* 主页模糊查询*/
    @RequestMapping("/queryBookByName")
    public String queryBookByName(String name,Model  model){
        List<Books> booksList = bookService.likeBooks(name);
        assert booksList!=null;
        if (booksList.isEmpty()){
            model.addAttribute("error","没有查询到");
        }else {
            model.addAttribute("booksList",booksList);
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
    public String updateBook(Book book, Author author, Types types){
        //修改书本表
        bookService.UpdateBook(book);
        //查询作者
        Author author1 = authorService.selectAuthor(author);

        //查询出作者为空创建一个作者
        if (author1==null) {
            int i = authorService.addAuthor(author);
            //添加成功
            if (i>0){
                //添加成功，去查询插入的作者
                Author author2 = authorService.selectAuthor(author);
                if (author2!=null){
                    Integer bid = book.getBid();
                    Integer aid = author2.getAid();
                    BookAuthor bookAuthor1 = bookAuthorService.selectBookAutor(bid);
                    if (bookAuthor1!=null){
                        BookAuthor bookAuthor = new BookAuthor();
                        bookAuthor.setBid(bid);
                        bookAuthor.setAid(aid);
                        bookAuthorService.UpdateBookAutor(bookAuthor);
                    }
                }
            }
        }else if (author1!=null){
            Integer bid = book.getBid();
            Integer aid = author1.getAid();
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setBid(bid);
            bookAuthor.setAid(aid);
            bookAuthorService.UpdateBookAutor(bookAuthor);
        }

        //查询类型
        Types types1 = typesService.selectTypes(types);
        if (types1==null){
            int i = typesService.AddTypes(types);
            if (i>0){
                Types types2 = typesService.selectTypes(types);
                if (types2!=null){
                    Integer tid = types2.getTid();
                    Integer bid = book.getBid();
                    BookTypes bookTypes1 = bookTypesService.AllBookTypes(bid);
                    if (bookTypes1!=null){
                        BookTypes bookTypes2 = new BookTypes();
                        bookTypes2.setBid(bid);
                        bookTypes2.setTid(tid);
                        bookTypesService.UpDateBookType(bookTypes2);
                    }
                }
            }
        } else if (types1!=null) {
            Integer tid = types1.getTid();
            Integer bid = book.getBid();
            BookTypes bookTypes = new BookTypes();
            bookTypes.setTid(tid);
            bookTypes.setBid(bid);
            bookTypesService.UpDateBookType(bookTypes);
        }
        return "redirect:allBook";
    }

    @RequestMapping("/addbook")
    public String addbook(){

        return "addBook";
    }
    @RequestMapping("/addBooks")
    public String addBooks (Book book,Author author,Types types,Model model){

        String bname = book.getBname();
        Book book1 = bookService.BookName(bname);

        if (book1==null){
            bookService.AddBook(book);
            Author author1 = authorService.selectAuthor(author);
            if (author1==null){
                authorService.addAuthor(author);
            }
            Types types1 = typesService.selectTypes(types);

            if (types1==null){
                typesService.AddTypes(types);
            }
            Book book2 = bookService.selectBookname(book);
            Author author2 = authorService.selectAuthor(author);
            Types types2 = typesService.selectTypes(types);

            Integer bid = book2.getBid();
            Integer aid = author2.getAid();
            BookAuthor bookAuthor1 = new BookAuthor();
            bookAuthor1.setAid(aid);
            bookAuthor1.setBid(bid);
            bookAuthorService.AdddBookAutoraid(bookAuthor1);


            Integer bid1 = book2.getBid();
            Integer tid = types2.getTid();
            BookTypes bookTypes1 = new BookTypes();
            bookTypes1.setTid(tid);
            bookTypes1.setBid(bid1);
            bookTypesService.AddBookTypes(bookTypes1);

            return "redirect:allBook";

        }
        model.addAttribute("msg","插入的书本已存在，请勿重复插入。");
        return "addBook";

    }
    @RequestMapping("/deleteBook")
    public String deleteBook(Book book){

        Integer bid = book.getBid();

        BookAuthor bookAuthor = bookAuthorService.selectBookAutor(bid);
        BookTypes bookTypes = bookTypesService.AllBookTypes(bid);

        if (bookAuthor!=null&&bookTypes!=null){
            Integer bid1 = bookTypes.getBid();
            Integer bid2 = bookAuthor.getBid();
            int i = bookAuthorService.deleteBookAutoraid(bid1);
            int i1 = bookTypesService.deleteBookTypes(bid2);
            if (i>0&&i1>0){
                bookService.deleteBook(bid);
            }



        }


        return "redirect:allBook";

    }

    @RequestMapping("/toMeans")
    public String gomeans(Model model,HttpSession httpSession){


        User user1 = (User) httpSession.getAttribute("user");


        if (user1!=null){
            model.addAttribute("user1",user1);
        }
        Integer uid = user1.getUid();
        List<Book> book = userBookService.SelectBookByid(uid);
        System.out.println(book);

        if (book!=null){

            model.addAttribute("book",book);

        }


        return "About";
    }


    @RequestMapping("/upMeans")
    public  String upMeans(User user){

        if (user!=null){
            String upassword = user.getUpassword();
            Integer uid = user.getUid();
            String uname = user.getUname();
            String email = user.getEmail();
            String phone = user.getPhone();
            Md5Hash md5Hash = new Md5Hash(upassword, uname, 1024);
            User user1 = new User();
            user1.setUid(uid);
            user1.setUname(uname);
            user1.setEmail(email);
            user1.setPhone(phone);
            user1.setUpassword(md5Hash.toString());
            userService.UpdateUser(user1);

        }


        return "redirect:toMeans";

    }
    /*用户订阅书籍删除*/
    @RequestMapping("/deleteUserBook")
    public String deleteUserBook(int id){

        userBookService.DeleteUserBook(id);

        return "redirect:/toMeans";
    }






}
