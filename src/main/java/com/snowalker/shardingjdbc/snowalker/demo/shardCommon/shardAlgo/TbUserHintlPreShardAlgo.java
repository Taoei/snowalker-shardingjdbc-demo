package com.snowalker.shardingjdbc.snowalker.demo.shardCommon.shardAlgo;


import com.snowalker.shardingjdbc.snowalker.demo.shardCommon.constant.ShardConstants;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:43 下午
 * @description
 **/
public class TbUserHintlPreShardAlgo implements HintShardingAlgorithm<Integer> {

    private static final String connetWord = "_000";

    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Integer> hintShardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : collection) {
            for (Integer value : hintShardingValue.getValues()) {
                String realTableName = ShardConstants.logicTableNameTUser + connetWord + value;
                if (each.equals(realTableName)) {
                    result.add(each);
                }
            }
        }
        //如果存在未匹配成功的情况，那么直接返回所有的表
        if(result.size() == 0){
            return collection;
        }
        return result;
    }
}