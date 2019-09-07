package lg.controller;

import io.swagger.annotations.Api;
import lg.bean.User;
import lg.dao.JpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * author: LG
 * date: 2019-09-04 13:45
 * desc:
 */
@Api(tags = "JPA")
@RestController
public class JpaController {

    @Autowired
    private JpaDao jpaDao;

    @GetMapping("gpaQuery")
    @Transactional                  //不起作用，有jpa自己写事务
    public Page<User> gpaQuery() {
        System.out.println("reutrn");
        Page<User> users = jpaDao.queryUser();
        System.out.println("reutrn");
        int i = 1/0;

        return users;
    }
}
