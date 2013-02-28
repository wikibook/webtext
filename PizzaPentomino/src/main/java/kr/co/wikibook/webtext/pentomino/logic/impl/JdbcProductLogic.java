/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.wikibook.webtext.pentomino.Constants;
import kr.co.wikibook.webtext.pentomino.exception.AppException;
import kr.co.wikibook.webtext.pentomino.logic.ProductLogic;
import kr.co.wikibook.webtext.pentomino.model.ProductItem;

/**
 * JDBC로 접근해 상품 정보를 취득하는 {@link ProductLogic}<br />
 * 
 * @author y-komori
 */
public class JdbcProductLogic implements ProductLogic {
    /* (non-Javadoc)
     * @see kr.co.wikibook.webtext.pentomino.logic.ProductLogic#getProductList()
     */
    public List<ProductItem> getProductList() {
        List<ProductItem> result = new ArrayList<ProductItem>();

        InitialContext ic;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 데이터 소스의 취득
            ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(Constants.DATA_SOURCE);

            // 커넥션의 취득
            conn = ds.getConnection();

            // SELECT 문장의 발행
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from PRODUCT_ITEM");

            // SELECT 결과를 ProductItem로 다시 채운다
            while (rs.next()) {
                String itemId = rs.getString("ITEM_ID");
                String itemName = rs.getString("ITEM_NAME");
                Integer price = rs.getInt("PRICE");

                result.add(new ProductItem(itemId, itemName, price));
            }
        } catch (NamingException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }
        }

        return result;
    }
}
