package com.wqm.ims.common.request.info;

import lombok.Data;

@Data
public class SetExtraInfoRequest {
    private int basicInfoKey;
    private String date;
    private int type;

    public SetExtraInfoRequest(int basicInfoKey, String date, int type) {
        this.basicInfoKey = basicInfoKey;
        this.date = date;
        this.type = type;
    }
}
