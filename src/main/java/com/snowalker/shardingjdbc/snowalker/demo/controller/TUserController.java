package com.snowalker.shardingjdbc.snowalker.demo.controller;

import com.github.pagehelper.PageInfo;
import com.snowalker.shardingjdbc.snowalker.demo.dto.TUserDTO;
import com.snowalker.shardingjdbc.snowalker.demo.entity.TUser;
import com.snowalker.shardingjdbc.snowalker.demo.service.TUserService;
import com.snowalker.shardingjdbc.snowalker.demo.vo.BaseResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 6:51 下午
 * @description
 **/
@RestController
@RequestMapping("/tUser/")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    @RequestMapping("queryTUser")
    public BaseResultVo queryTUser(TUserDTO tUserDTO) {
        if (tUserDTO.getPageNum() == null || tUserDTO.getPageSize() == null) {
            tUserDTO.setPageNum(1);
            tUserDTO.setPageSize(2);
        }
        return BaseResultVo.builder().data(tUserService.queryTUser(tUserDTO)).build();
    }

    @RequestMapping("addTUser")
    public BaseResultVo addTUser(@RequestBody TUserDTO tUserDTO) {
        TUser tUser = tUserService.addTUser(tUserDTO);
        return BaseResultVo.builder().data(tUser).build();
    }

}
