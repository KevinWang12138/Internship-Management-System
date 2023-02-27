package com.wqm.ims.common;

import lombok.Data;

@Data
public class Response {
    public Integer errNo;
    public String errMsg;
    public Object data;

    public Response(int errNo, String errMsg, Object data) {
        this.errNo=errNo;
        this.errMsg=errMsg;
        this.data=data;
    }
}
