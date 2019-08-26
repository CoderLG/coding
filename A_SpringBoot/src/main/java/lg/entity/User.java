package lg.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * author: LG
 * date: 2019-08-18 13:06
 * desc:
 */
@Getter
@Setter
@Slf4j
public class User {

    private String name;
    private String age;

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setAge("18");
        log.info("lombok 集成");
        System.out.println(user);
    }
}
