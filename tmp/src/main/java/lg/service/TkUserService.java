package lg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lg.entity.User;
import lg.mapper.tk.TkUserMapper;
import lg.tkentity.TkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class TkUserService {

    @Autowired
    private TkUserMapper tkUserMapper;


    public TkUser queryUserById(Long id){

        TkUser insert = tkUserMapper.selectByPrimaryKey(id);
        return insert;

    }

    @Transactional
    public void deleteUser(int id){

        tkUserMapper.deleteByPrimaryKey(id);


    }



}
