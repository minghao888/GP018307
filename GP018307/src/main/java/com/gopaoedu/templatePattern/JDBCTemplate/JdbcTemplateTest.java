package com.gopaoedu.templatePattern.JDBCTemplate;

import com.gopaoedu.templatePattern.JDBCTemplate.dao.MemberDao;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
