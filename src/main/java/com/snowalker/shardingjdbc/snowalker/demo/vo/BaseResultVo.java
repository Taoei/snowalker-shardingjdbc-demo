package com.snowalker.shardingjdbc.snowalker.demo.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/28 5:37 下午
 * @description
 **/
@Data
@Builder
public class BaseResultVo implements Serializable {

    private Integer code = 200;

    private Object data;

}
