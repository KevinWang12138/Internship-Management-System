package com.wqm.ims.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ExtraCalenderInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer basicInfoKey;
    private String date;
    private Integer type;

    public ExtraCalenderInfo() {
    }

    public ExtraCalenderInfo(Integer basicInfoKey, String date, Integer type) {
        this.basicInfoKey = basicInfoKey;
        this.date = date;
        this.type = type;
    }
}
