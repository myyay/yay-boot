package com.yay.disrupter.common;

import java.io.Serializable;

/**
 * 描述: 传输数据
 * @author yangyang26
 * @version 1.0
 * @since 2019/2/21 15:18
 */
public class DataDto implements Serializable {
    /** id */
    private Long id;
    /** 描述 */
    private String desc;

    public DataDto() {
    }

    public DataDto(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
