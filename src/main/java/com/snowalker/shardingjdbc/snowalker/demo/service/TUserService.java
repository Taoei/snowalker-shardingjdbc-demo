package com.snowalker.shardingjdbc.snowalker.demo.service;

import com.github.pagehelper.PageInfo;
import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;


/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:41 下午
 * @description
 **/
public interface TUserService {

    PageInfo<TUser> queryTUser(TUserDTO tUserDTO);

    TUser addTUser(TUserDTO tUserDTO);

}
