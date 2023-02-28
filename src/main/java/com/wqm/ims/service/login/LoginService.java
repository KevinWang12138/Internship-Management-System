package com.wqm.ims.service.login;

import com.wqm.ims.common.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.wqm.ims.common.Constant.*;

@Service
public class LoginService {
    @Transactional
    public Response login(String phone,String password,int role){
        //todo 调用dao层进行登录校验
        //校验是否有这个用户

        //校验密码是否正确

        boolean ok=true;
        if(ok){
            return new Response(0,"","登录成功");
        }else{
            return new Response(loginErrorNo,loginErrorMsg,null);
        }
    }
}
