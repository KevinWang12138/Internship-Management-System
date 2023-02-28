package com.wqm.ims.controller.login;

import com.wqm.ims.common.CommonFunction;
import com.wqm.ims.common.Response;
import com.wqm.ims.common.request.login.LoginRequest;
import com.wqm.ims.service.login.LoginService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.wqm.ims.common.Constant.*;

@RestController
@ResponseBody
public class LoginController {
    @Resource
    private LoginService loginService;
    @PostMapping("/login")
    public Response login(@RequestBody LoginRequest request){
        String phone=request.getPhone();
        String password=request.getPassword();
        int role=request.getRole();
        Response response=null;
        //参数校验
        if(phone==""||password==""){
            return new Response(paramErrorNo,paramErrorMsg,null);
        }
        boolean phoneOk=CommonFunction.phoneVerification(phone);
        if(!phoneOk){
            return new Response(phoneErrorNo,phoneErrorMsg,null);
        }

        //调用service进行登录操作
        response=loginService.login(phone,password,role);
        return response;
    }
}
