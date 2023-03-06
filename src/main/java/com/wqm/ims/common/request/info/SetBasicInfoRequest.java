package com.wqm.ims.common.request.info;

import lombok.Data;

@Data
public class SetBasicInfoRequest {
    private String companyId;
    private String companyName;
    private String startDate;
    private String endDate;
    private String startWorkTime;
    private String endWordTime;
    private int workType;
}
