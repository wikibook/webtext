/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.dao.impl;

import java.sql.SQLException;
import java.util.List;

import kr.co.wikibook.webtext.pentomino.dao.ProductItemDao;
import kr.co.wikibook.webtext.pentomino.model.ProductItem;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

/**
 * {@link ProductItemDao}의 구현 클래스.<br />
 * 
 * @author y-komori
 */
public class ProductItemDaoImpl extends SqlMapDaoTemplate implements
        ProductItemDao {

    public ProductItemDaoImpl(DaoManager daoManager) {
        super(daoManager);
    }

    /* (non-Javadoc)
     * @see kr.co.wikibook.webtext.pentomino.dao.ProductItemDao#selectAll()
     */
    @Override
    public List<ProductItem> selectAll() throws SQLException {
        return getSqlMapExecutor().queryForList("selectAll");
    }
}
