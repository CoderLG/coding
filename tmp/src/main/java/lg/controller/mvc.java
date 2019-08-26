package lg.controller;

import com.github.pagehelper.PageInfo;
import lg.entity.User;
import lg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mvc {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public int insertUser(String name,Integer age) {
        return  userService.insertUser(name,age);
    }

    @RequestMapping("/selectUser")
    public User selectUser(String name) {
        return  userService.selectUser(name);
    }

    @RequestMapping("/updateUser")
    public int updateUser(String name,int id) {
        return  userService.updateUser(name,id);
    }
    @RequestMapping("/deleteUser")
    public int deleteUser(int id) {
        return  userService.deleteUser(id);
    }


    @RequestMapping("/findAny")
    public PageInfo<User> findAny(int page,int pageSize) {
        return  userService.findAny(page,pageSize);
    }

}
