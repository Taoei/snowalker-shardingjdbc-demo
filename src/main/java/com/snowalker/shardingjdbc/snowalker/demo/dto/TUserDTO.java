package com.snowalker.shardingjdbc.snowalker.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:43 下午
 * @description
 **/
@Data
public class TUserDTO implements Serializable {

    private Integer pageNum;
    private Integer pageSize;
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer regionId;
    private List<Integer> idList;
    private List<Integer> userIdList;
    private List<Integer> regionIdList;

}
