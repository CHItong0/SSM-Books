import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class  Test {

    public static void main(String[] args) {

        String s ="ls";

        Md5Hash md5Hash = new Md5Hash("123","ls",1024);

        System.out.println(md5Hash);


    }




}
