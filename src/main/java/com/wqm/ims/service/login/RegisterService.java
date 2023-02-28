package com.wqm.ims.service.login;

import com.wqm.ims.common.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    @Transactional
    public Response register(String phone,String password,int role){
        //todo 调用dao层
        //校验该手机号是否注册过

        //进行注册

        return new Response(0,"","注册成功");
    }
}
