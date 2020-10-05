package com.snowalker.shardingjdbc.snowalker.demo.manager.impl;

import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;
import com.snowalker.shardingjdbc.snowalker.demo.manager.TUserManager;
import com.snowalker.shardingjdbc.snowalker.demo.mapper.TUserMapper;
import com.snowalker.shardingjdbc.snowalker.demo.utils.ShardingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 9:39 上午
 * @description
 **/
@Component
public class TUserManagerImpl implements TUserManager {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> selectTUser(TUserDTO tUserDTO) {
        ShardingUtil.putTUserShardingValue(tUserDTO.getRegionIdList(), tUserDTO.getUserIdList());
        return tUserMapper.selectIds(tUserDTO);
    }

    @Override
    public TUser insertTUser(TUser tUser) {
        ShardingUtil.putTUserShardingValue(tUser.getRegionId(), tUser.getUserId());
        tUserMapper.insert(tUser);
        return tUser;
    }

}
