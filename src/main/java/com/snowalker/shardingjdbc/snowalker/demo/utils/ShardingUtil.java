package com.snowalker.shardingjdbc.snowalker.demo.utils;

import com.snowalker.shardingjdbc.snowalker.demo.shardCommon.constant.ShardConstants;
import org.apache.shardingsphere.api.hint.HintManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 9:33 上午
 * @description
 **/
public class ShardingUtil {

    private static int getDbShardingNum(Integer key) {
        if(key == null || key == 0){
            return -1;
        }
        return (int) (key & (ShardConstants.dbNum - 1));
    }

    public static List<Integer> getDbShardingNumList(List<Integer> keys){
        if(keys == null || keys.size() == 0){
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        for(Integer key : keys){
            Integer num = (key & (ShardConstants.dbNum - 1));
            resList.add(num);
        }
        return resList;
    }

    public static int getTUserShardingNum(Integer key){
        if(key == null || key == 0){
            return -1;
        }
        return (new Integer(key.toString().substring(key.toString().length() - 1)) & (ShardConstants.tableNumTUser - 1));
    }

    public static List<Integer> getTUserShardingNumList(List<Integer> keys){
        if(keys == null || keys.size() == 0){
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        for(Integer key : keys){
            Integer num = (new Integer(key.toString().substring(key.toString().length() - 1)) & (ShardConstants.tableNumTUser - 1));
            resList.add(num);
        }
        return resList;
    }


    public static void putTUserShardingValue(Integer regionId, Integer UserId){
        int dbShardingNum = getDbShardingNum(regionId);
        int tUserShardingNum = getTUserShardingNum(UserId);
        putTUserShardingValueDirect(dbShardingNum, tUserShardingNum);
    }

    public static void putTUserShardingValue(List<Integer> regionIds, List<Integer> userIdList){
        List<Integer> dbShardingNumList = getDbShardingNumList(regionIds);
        List<Integer> tUserShardingNumList = getTUserShardingNumList(userIdList);
        putTUserShardingValueDirect(dbShardingNumList, tUserShardingNumList);
    }

    public static void putTUserShardingValueDirect(int shardingDbNum,int shardingTableNum){
        if(HintManager.getDatabaseShardingValues(ShardConstants.logicTableNameTUser) != null){
            HintManager.clear();
        }
        if(HintManager.getTableShardingValues(ShardConstants.logicTableNameTUser) != null){
            HintManager.clear();
        }
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue(ShardConstants.logicTableNameTUser, shardingDbNum);
        hintManager.addTableShardingValue(ShardConstants.logicTableNameTUser, shardingTableNum);
    }

    public static void putTUserShardingValueDirect(List<Integer> shardingDbNumList,List<Integer> shardingTableNumList){
        if(HintManager.getDatabaseShardingValues(ShardConstants.logicTableNameTUser) != null){
            HintManager.clear();
        }
        if(HintManager.getTableShardingValues(ShardConstants.logicTableNameTUser) != null){
            HintManager.clear();
        }
        HintManager hintManager = HintManager.getInstance();
        for (Integer num : shardingDbNumList) {
            hintManager.addDatabaseShardingValue(ShardConstants.logicTableNameTUser, num);
        }
        for(Integer num : shardingTableNumList){
            hintManager.addTableShardingValue(ShardConstants.logicTableNameTUser, num);
        }
    }

    public static void clearHintManager(){
        HintManager.clear();
    }

}
