package lg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lg.entity.User;
import lg.mapper.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String name,Integer age){

        int insert = userMapper.insertUser(name,age);
        return age;

    }


    public PageInfo<User> findAny(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<User> any = userMapper.findAny();
        PageInfo<User> userPageInfo = new PageInfo<>(any);

        return userPageInfo;

    }
    public User selectUser(String name){

        User insert = userMapper.findByName(name);
        return insert;

    }

    public int updateUser(String name,int id){

        int i = userMapper.updateUser(name, id);
        return i;

    }

    public int deleteUser(int id){

        int i = userMapper.deleteUser(id);
        return i;

    }



}
