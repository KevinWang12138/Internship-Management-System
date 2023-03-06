package com.wqm.ims.service.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.ims.bean.User;
import com.wqm.ims.common.Response;
import com.wqm.ims.dao.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.wqm.ims.common.Constant.*;

@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    @Transactional
    public Response login(String phone,String password,int role){
        //校验是否有这个用户
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone);
        wrapper.eq("role",role);
        User u = userMapper.selectOne(wrapper);
        if(u==null){
            return new Response(phoneNotExistErrorNo,phoneNotExistErrorMsg,null);
        }
        //校验密码是否正确
        if(!u.getPassword().equals(password)){
            return new Response(passwordErrorNo,passwordErrorMsg,null);
        }
        return new Response(0,"","登录成功");
    }
}
