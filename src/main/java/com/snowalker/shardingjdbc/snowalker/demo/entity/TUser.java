package com.snowalker.shardingjdbc.snowalker.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:43 下午
 * @description
 **/
@Data
public class TUser implements Serializable {

    private Integer id;
    private Integer userId;
    private String userName;
    private Integer regionId;
    private Date createTime;

    public String getCreateTimeDesc() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
    }


}
