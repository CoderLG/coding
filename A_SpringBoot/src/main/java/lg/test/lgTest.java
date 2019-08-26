package cn.com.geovis.center.tiltphoto;

import java.util.HashMap;
import java.util.Map;

/**
 * author: LG
 * date: 2019-08-15 20:09
 * desc:
 */

public class lgTest {
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


        assert1(a);
        assert2(map);
        assert3(str);
        assert4(b);
        System.out.println(b);

    }


}
