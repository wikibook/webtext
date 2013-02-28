/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import kr.co.wikibook.webtext.pentomino.Constants;
import kr.co.wikibook.webtext.pentomino.dao.ProductItemDao;
import kr.co.wikibook.webtext.pentomino.exception.AppException;
import kr.co.wikibook.webtext.pentomino.logic.ProductLogic;
import kr.co.wikibook.webtext.pentomino.model.ProductItem;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

/**
 * iBATIS로 상품 정보를 취득하는 {@link ProductLogic}<br />
 * 
 * @author y-komori
 */
public class IbatisProductLogic implements ProductLogic {
    /* (non-Javadoc)
     * @see kr.co.wikibook.webtext.pentomino.logic.ProductLogic#getProductList()
     */
    public List<ProductItem> getProductList() {
        // DAO의 취득
        ProductItemDao productItemDao;
        try {
            Reader reader = Resources.getResourceAsReader(Constants.DAO_CONFIG);
            DaoManager daoManager = DaoManagerBuilder.buildDaoManager(reader);
            productItemDao = (ProductItemDao) daoManager
                    .getDao(ProductItemDao.class);
        } catch (IOException ex) {
            throw new AppException(ex);
        }

        // 상품 정보 목록의 취득
        List<ProductItem> result;
        try {
            result = productItemDao.selectAll();
        } catch (SQLException ex) {
            throw new AppException(ex);
        }

        return result;
    }
}
