package com.gopaoedu.templatePattern.JDBCTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC连接数据库模板
 */
public abstract class JdbcTemplate {

    private DataSource dataSource = null;
    //1.通过构造 获取数据源
    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper,Object[] objs){
        try {
            //1.获取连接
            Connection conn = this.getConnection();
            //2.创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn,sql);
            //3.执行语句集
            ResultSet rs = this.excuteQuery(pstm,objs);
            //4.处理结果集
            List<?> result = this.paresResultSet(rs,rowMapper);
            //5.关闭结果集
            this.closeResultSet(rs);
            //6.关闭语句集
            this.closeStatement(pstm);
            //7.关闭连接
            this.closeConnection(conn);

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection conn) throws SQLException {
        //这里可以不关闭数据源，放回连接池就可以了
        conn.close();
    }

    private void closeStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    /**
     * 处理数据库查询的结果集合
     * @param rs  查询数据库的ResultSet结果
     * @param rowMapper
     * @return
     * @throws Exception
     */
    protected List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();

        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return result;
    }



    /**
     * 拼装sql和属性值，并查询和返回
     * @param pstm
     * @param objs
     * @return
     * @throws SQLException
     */
    protected ResultSet excuteQuery(PreparedStatement pstm, Object[] objs) throws SQLException {
        for (int i = 0; i < objs.length; i++) {
            pstm.setObject(i+1,objs[i]);
        }
        return pstm.executeQuery();
    }
    /**
     * 创建语句集合
     * @param conn 连接对象
     * @param sql  操作数据库sql
     * @return
     */
    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    /**
     * 从DataSource中获取连接
     * @return
     */
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
