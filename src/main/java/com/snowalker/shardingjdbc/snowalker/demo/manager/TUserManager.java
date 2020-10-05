package com.snowalker.shardingjdbc.snowalker.demo.manager;

import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;

import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 9:33 上午
 * @description
 **/
public interface TUserManager {

    List<TUser> selectTUser(TUserDTO tUserDTO);

    TUser insertTUser(TUser tUser);

}
