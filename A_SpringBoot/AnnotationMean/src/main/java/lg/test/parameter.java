package lg.test;

import java.util.HashMap;
import java.util.Map;

/**
 * author: LG
 * date: 2019-08-15 20:09
 * desc:
 * 验证传入的是引用是否会改变值
 * 基础类型不会变
 * 下面的类型只有map 变了
 *
 */

public class parameter {
    public static int assert1(Integer a ){
        a=1;
        return a ;
    }

    public static Map assert2(Map a ){
       a.put("a","a");
        return a ;
    }
    public   static  String assert3(String a ){
        a = "word";
        return a ;
    }

    public   static  boolean assert4(boolean a ){
        a= false;
        return a ;
    }
    public static void main(String[] args) {

        Integer a = 0;
        String str = "he";
        boolean b = true;
        Map<String,String> map = new HashMap<>();

        //Integer
        assert1(a);
        System.out.println(a);

        //String
        assert3(str);
        System.out.println(str);

        //boolean
        assert4(b);
        System.out.println(b);

        //---------------变-----------------


        //Map
        assert2(map);
        System.out.println(map);





    }


}
