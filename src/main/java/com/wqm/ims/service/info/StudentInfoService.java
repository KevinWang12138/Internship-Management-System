package com.wqm.ims.service.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.ims.bean.BasicCalendarInfo;
import com.wqm.ims.common.Response;
import com.wqm.ims.common.request.info.SetBasicInfoRequest;
import com.wqm.ims.dao.BasicCalenderInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.wqm.ims.common.Constant.*;

@Service
@Transactional
public class StudentInfoService {
    @Resource
    private BasicCalenderInfoMapper basicCalenderInfoMapper;
    public Response SetBasicInternshipInfo(String userId,SetBasicInfoRequest request){
        //判断新实习日期是否和旧的实习冲突
        //把该学生的所有实习信息都读取下来
        QueryWrapper<BasicCalendarInfo> wrapper=new QueryWrapper<>();
        wrapper.eq("student_id",userId);
        List<BasicCalendarInfo> basicCalenderInfos = basicCalenderInfoMapper.selectList(wrapper);
        boolean canInsert = isGoodDate(basicCalenderInfos, request.getStartDate(), request.getEndDate());
        //如果冲突则返回失败信息
        if(!canInsert){
            return new Response(commonErrorNo,"实习日期存在冲突",null);
        }
        //不冲突，则正常写入日期即可
        int ok = basicCalenderInfoMapper.insert(new BasicCalendarInfo(null,userId,request.getCompanyId(),request.getCompanyName(),request.getStartDate(),request.getEndDate(),request.getStartWorkTime(),request.getEndWordTime(),request.getWorkType()));
        if(ok!=1){
            return new Response(commonErrorNo,commonErrorMsg,null);
        }
        return new Response(0,"",null);
    }
    //判断当前日期是否能实习
    private boolean isGoodDate(List<BasicCalendarInfo> oldCalendarInfos,String newStartDate,String newEndDate){
        for(BasicCalendarInfo info:oldCalendarInfos){
            String oldStartDate = info.getStartDate();
            String oldEndDate = info.getEndDate();
            //判断当前开始日期是否晚于旧结束日期，如果晚于则ok
            if(compareDate(oldEndDate,newStartDate)){
                continue;
            }
            //判断当前结束日期是否早于旧开始日期，如果早于则ok
            if(compareDate(newEndDate,oldStartDate)){
                continue;
            }
            //和当前日期冲突返回false
            return false;
        }
        return true;
    }
    //日期A是否早与日期B
    private boolean compareDate(String dateA,String dateB){
        return dateA.compareTo(dateB)<0;
    }
}
