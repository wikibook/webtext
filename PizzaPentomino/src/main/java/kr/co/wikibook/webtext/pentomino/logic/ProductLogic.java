/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic;

import java.util.List;

import kr.co.wikibook.webtext.pentomino.model.ProductItem;

/**
 * 상품 정보를 취급하기 위한 비즈니스 로직의 인터페이스<br />
 * 
 * @author y-komori
 */
public interface ProductLogic {
    /**
     * 상품 정보 목록을 돌려준다.<br />
     * 
     * @return 상품 정보 목록
     */
    public List<ProductItem> getProductList();
}
