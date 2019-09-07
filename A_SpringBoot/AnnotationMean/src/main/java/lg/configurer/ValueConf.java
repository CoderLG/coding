package lg.configurer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-09-02 10:43
 * desc:
 */
@Component
public class ValueConf {

    private  String user;

    @Value("${Dbname}")
    public void setUsersss(String name,String a) {
        String ab = a+"as";
        this.user = name;
    }

    public void Say(){
        System.out.println(this.user);
    }
}
