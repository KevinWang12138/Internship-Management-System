package com.wqm.ims.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BasicCalendarInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String studentId;
    private String companyId;
    private String companyName;
    private String startDate;
    private String endDate;
    private String startWorkTime;
    private String endWorkTime;
    private int workType;
    public BasicCalendarInfo(){

    }
    public BasicCalendarInfo(String studentId, String companyId, String companyName, String startDate, String endDate, String startWorkTime, String endWorkTime, int workType) {
        this.studentId = studentId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
        this.workType = workType;
    }
}
