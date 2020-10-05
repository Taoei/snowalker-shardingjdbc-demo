package com.snowalker.shardingjdbc.snowalker.demo.shardCommon.biz.pageBiz;

import com.github.pagehelper.Page;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/24 5:43 下午
 * @description
 **/
public class PageHolder {
    protected static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<Page>();

    public static void setLocalPage(Page page) {
        pageThreadLocal.set(page);
    }

    public static <T> Page<T> getLocalPage() {
        return pageThreadLocal.get();
    }

    public static void clearPage() {
        pageThreadLocal.remove();
    }
}
