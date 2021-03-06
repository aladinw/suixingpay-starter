package com.suixingpay.takin.mybatis.page.dialect;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;

/**
 * 数据库方言，针对不同数据库进行实现
 * 
 * @author: qiujiayu[qiu_jy@suixingpay.com]
 * @date: 2018年1月24日 上午10:06:31
 * @version: V1.0
 * @review: qiujiayu[qiu_jy@suixingpay.com]/2018年1月24日 上午10:06:31
 */
public interface Dialect {
    // 分页的id后缀
    String SUFFIX_PAGE = "_PAGE";
    // 第一个分页参数
    String PAGEPARAMETER_FIRST = "FIRST" + SUFFIX_PAGE;
    // 第二个分页参数
    String PAGEPARAMETER_SECOND = "SECOND" + SUFFIX_PAGE;

    /**
     * 处理查询参数对象
     *
     * @param ms MappedStatement
     * @param parameterObject
     * @param rowDounds
     * @param boundSql
     * @param pageKey
     * @return
     */
    Object processParameterObject(MappedStatement ms, Object parameterObject, BoundSql boundSql, RowBounds rowBounds,
            CacheKey pageKey);

    /**
     * 生成分页查询 sql
     * 
     * @param sql
     * @param rowBounds
     * @param pageKey
     * @return
     */
    String getPageSql(String sql, RowBounds rowBounds, CacheKey pageKey);

}
