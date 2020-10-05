package com.snowalker.shardingjdbc.snowalker.demo.shardCommon.dataSourceRoute.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:43 下午
 * @description
 **/
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return "dbShardMaster";
    }
}