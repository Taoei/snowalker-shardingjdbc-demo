package com.snowalker.shardingjdbc.snowalker.demo.shardCommon.constant;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 9:33 上午
 * @description
 **/
public class ShardConstants {

    public static final String logicDb = "taowei";

    //用户逻辑表名
    public static final String logicTableNameTUser = "t_user";

    public static final int dbNum = 2;

    //用户分表数
    public static final int tableNumTUser = 4;

}
