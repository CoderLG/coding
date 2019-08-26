package lg.controller;

import com.github.pagehelper.PageInfo;
import lg.entity.User;
import lg.service.TkUserService;
import lg.service.UserService;
import lg.tkentity.TkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TkController {

    @Autowired
    private TkUserService tkUserService;


    @GetMapping("/getUser/{id}")        //PathVariable  RequestParam --> url?id=1
    public TkUser selectUser(@PathVariable("id") Long id) {
        return  tkUserService.queryUserById(id);
    }

}
