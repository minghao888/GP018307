package com.gopaoedu.templatePattern.JDBCTemplate.dao;

import com.gopaoedu.templatePattern.JDBCTemplate.JdbcTemplate;
import com.gopaoedu.templatePattern.JDBCTemplate.Member;
import com.gopaoedu.templatePattern.JDBCTemplate.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 业务层，dao层继承jdbc模板，进行数据连接
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 查询所有
     * @return
     */
    public List<?> selectAll(){

        String sql = "select * from t_memberInfo";

        /**
         * new RowMapper<Member>() 此刻创建的原因：
         *
         *      因为RowMapper<?>是一个接口，也没有具体实现，所以我们再这个地方创建出实现类，
         *      当作参数（对象参数）传给excuteQuery()方法，给方法里面的其他需要调用的地方进行调用。
         *
         *      如果RowMapper<?>不是接口，而是普通类，那么就是一个意思了，
         *      只是是接口，我们创建的时候直接再参数上面出现了具体方法，所以会比较绕。
         *   注意：
         *      new 普通类当作参数：
         *          可以直接调用，因为代码已经有了。
         *      new 接口类当作参数：
         *          必须实现接口类中的方法体，因为接口类没有方法体，实例化以后当作参数就必须有
         *
         */
        //调用JdbcTemplate模板进行查询数据库
        return  super.excuteQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {

                Member member = new Member();
                //字段过多，原型模式
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);
    }

    /**
     *
     * new RowMapper<Member>() {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws Exception {
            Member member = new Member();
            //字段过多，原型模式
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));
            return member;
        }
      }

     * 作用，是将RowMapper 这个接口的实现类传获取，并不是此刻就进行代码取值，
     * 传过去以后，给 paresResultSet(ResultSet rs, RowMapper<?> rowMapper) 这个方法调用
     *
     *
     */
}
