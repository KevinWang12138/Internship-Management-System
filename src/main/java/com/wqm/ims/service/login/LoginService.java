package com.wqm.ims.service.login;

import com.wqm.ims.common.Response;
import org.springframework.stereotype.Service;

import static com.wqm.ims.common.Constant.*;

@Service
public class LoginService {
    public Response login(String phone,String password,int role){
        //todo 调用dao层进行登录校验
        boolean ok=true;
        if(ok){
            return new Response(0,"","登录成功");
        }else{
            return new Response(loginErrorNo,loginErrorMsg,null);
        }
    }
}
