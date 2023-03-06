package com.wqm.ims.common.request.info;

import lombok.Data;

@Data
public class SetBasicInfoRequest {
    private String companyId;
    private String companyName;
    private String startDate;

    public SetBasicInfoRequest(String companyId, String companyName, String startDate, String endDate, String startWorkTime, String endWordTime, int workType) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startWorkTime = startWorkTime;
        this.endWordTime = endWordTime;
        this.workType = workType;
    }

    private String endDate;
    private String startWorkTime;
    private String endWordTime;
    private int workType;
}
