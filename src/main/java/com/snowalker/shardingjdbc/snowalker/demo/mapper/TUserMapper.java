package com.snowalker.shardingjdbc.snowalker.demo.mapper;

import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;

import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/23 4:55 下午
 * @description
 **/
public interface TUserMapper {

    List<TUser> selectIds(TUserDTO tUserDTO);

    void insert(TUser tUser);

}
