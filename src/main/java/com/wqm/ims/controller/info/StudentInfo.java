package com.wqm.ims.controller.info;

import com.wqm.ims.common.CommonFunction;
import com.wqm.ims.common.Response;
import com.wqm.ims.common.request.info.SetBasicInfoRequest;
import com.wqm.ims.service.info.StudentInfoService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.wqm.ims.common.Constant.*;

@RestController
public class StudentInfo {
    @Resource
    private StudentInfoService studentInfoService;
    @PostMapping("/basic_info/set")
    public Response SetBasicInternshipInfo(@RequestBody SetBasicInfoRequest request, HttpServletRequest httpServletRequest){
        String userId=httpServletRequest.getParameter("userId");
        //参数校验
        if(!CommonFunction.phoneVerification(userId)){
            return new Response(commonErrorNo,commonErrorMsg,null);
        }
        if(request.getCompanyName()==""&&request.getCompanyId()==""){
            return new Response(paramErrorNo,"公司名不能为空",null);
        }
        //todo 校验日期正确性，需要制定规则

        //调用service存储实习信息
        Response response = studentInfoService.SetBasicInternshipInfo(userId,request);

        return response;
    }
}
