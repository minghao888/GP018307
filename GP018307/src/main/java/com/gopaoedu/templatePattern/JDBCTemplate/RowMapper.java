package com.gopaoedu.templatePattern.JDBCTemplate;

import java.sql.ResultSet;

/**
 * 接口类，将数据库查询出来的数据，进行转换
 * @param <T>
 */
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum) throws Exception;
}
