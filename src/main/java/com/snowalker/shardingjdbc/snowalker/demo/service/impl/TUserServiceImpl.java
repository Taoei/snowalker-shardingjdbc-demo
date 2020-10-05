package com.snowalker.shardingjdbc.snowalker.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;
import com.snowalker.shardingjdbc.snowalker.demo.manager.TUserManager;
import com.snowalker.shardingjdbc.snowalker.demo.service.TUserService;
import com.snowalker.shardingjdbc.snowalker.demo.utils.BeanTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:47 下午
 * @description
 **/
@Service("tUserService")
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserManager tUserManager;

    @Override
    public PageInfo<TUser> queryTUser(TUserDTO tUserDTO) {
        PageHelper.startPage(tUserDTO.getPageNum(), tUserDTO.getPageSize());
        List<TUser> tUsers = tUserManager.selectTUser(tUserDTO);
        if (CollectionUtils.isEmpty(tUsers)) {
            return null;
        }
        PageInfo<TUser> pageInfo = new PageInfo(tUsers);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TUser addTUser(TUserDTO tUserDTO) {
        TUser tUser = BeanTransferUtil.convertBean(tUserDTO, TUser.class);
        tUser.setCreateTime(new Date());
        tUser = tUserManager.insertTUser(tUser);
        Integer.parseInt("aaaaa");
        return tUser;
    }

}
