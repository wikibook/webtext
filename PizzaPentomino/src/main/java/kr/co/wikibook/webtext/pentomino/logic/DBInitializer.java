/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.littleforest.util.db.SQLExecutor;
import jp.littleforest.util.io.StreamUtil;
import jp.littleforest.util.resource.ResourceUtil;
import kr.co.wikibook.webtext.pentomino.Constants;

/**
 * 피자 펜토미노 용 데이터베이스를 초기화하기 위한 클래스<br />
 * 
 * @author y-komori
 */
public class DBInitializer {

    public static void initialize() throws ClassNotFoundException,
            SQLException, IOException, NamingException {
        Connection conn = getConnection();

        executeSql(conn, "createtable.sql");
        executeSql(conn, "insertdata.sql");

        conn.close();
    }

    private static Connection getConnection() throws NamingException,
            SQLException {
        InitialContext ic;
        ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup(Constants.DATA_SOURCE);
        return ds.getConnection();
    }

    private static void executeSql(Connection conn, String fileName)
            throws IOException, SQLException {
        InputStream is = null;
        try {
            is = ResourceUtil.getResourceAsStream(fileName);
            SQLExecutor.executeSQL(conn, is);
        } finally {
            StreamUtil.closeStream(is);
        }
    }
}
