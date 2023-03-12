package com.wqm.ims.controller.info;

import com.wqm.ims.common.CommonFunction;
import com.wqm.ims.common.Response;
import com.wqm.ims.common.request.info.SetBasicInfoRequest;
import com.wqm.ims.common.request.info.SetExtraInfoRequest;
import com.wqm.ims.service.info.StudentInfoService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.wqm.ims.common.Constant.*;
import static com.wqm.ims.common.CommonFunction.*;

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
        //校验日期正确性
        boolean dateOk=dateOrderVerification(request.getStartDate(), request.getEndDate());
        if(!dateOk){
            return new Response(paramErrorNo,"日期格式错误",null);
        }
        //todo 校验时间正确性
        //调用service存储实习信息
        Response response = studentInfoService.SetBasicInternshipInfo(userId,request);

        return response;
    }

    /**
     * 为一段实习增加特殊日期请求
     * 如 病假，团建，居家办公...
     */
    @PostMapping("/extra_info/set")
    public Response SetExtraInternshipInfo(@RequestBody SetExtraInfoRequest request){
        //校验日期正确性
        boolean dateOk=dateVerification(request.getDate());
        if(!dateOk){
            return new Response(paramErrorNo,"日期格式错误",null);
        }
        //调用service存储额外实习信息
        Response response = studentInfoService.SetSpecialInternshipInfo(request);
        return response;
    }
}
