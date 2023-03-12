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
public class RegisterService {
    @Resource
    private UserMapper userMapper;
    @Transactional
    public Response register(String phone,String password,int role){
        //校验该手机号是否注册过
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone);
        wrapper.eq("role",role);
        User u = userMapper.selectOne(wrapper);
        if(u!=null){
            return new Response(phoneExistErrorNo,phoneExistErrorMsg,null);
        }
        //进行注册
        User user=new User(phone,password,role);
        int ok=userMapper.insert(user);
        if(ok!=1){
            return new Response(commonErrorNo,commonErrorMsg,null);
        }
        return new Response(0,"","注册成功");
    }
}
