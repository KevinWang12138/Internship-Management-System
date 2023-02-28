package com.wqm.ims.controller.login;

import com.wqm.ims.common.CommonFunction;
import com.wqm.ims.common.Response;
import com.wqm.ims.common.request.login.RegisterRequest;
import com.wqm.ims.service.login.RegisterService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.wqm.ims.common.Constant.*;
import static com.wqm.ims.common.Constant.phoneErrorMsg;

@RestController
public class RegisterController {
    @Resource
    private RegisterService service;

    @PostMapping("/register")
    public Response register(@RequestBody RegisterRequest request){
        String phone=request.getPhone();
        String password=request.getPassword();
        int role=request.getRole();
        Response response=null;
        //参数校验
        if(phone==""||password==""){
            return new Response(paramErrorNo,paramErrorMsg,null);
        }
        boolean phoneOk= CommonFunction.phoneVerification(phone);
        if(!phoneOk){
            return new Response(phoneErrorNo,phoneErrorMsg,null);
        }
        response = service.register(phone,password,role);

        return response;
    }
}
