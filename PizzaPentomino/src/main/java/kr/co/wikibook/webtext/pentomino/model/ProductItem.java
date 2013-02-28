/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.model;

import java.io.Serializable;

/**
 * 상품 정보를 나타내는 클래스<br />
 * 
 * @author y-komori
 */
public class ProductItem implements Serializable {
    private static final long serialVersionUID = 2665335486985784409L;

    // 상품ID
    private String itemId;

    // 상품명
    private String itemName;

    // 상품 가격
    private int price;

    /**
     * 상품 정보를 구축한다.<br />
     */
    public ProductItem() {
    }

    /**
     * 속성을 지정해 상품 정보를 구축한다.<br />
     * 
     * @param itemId 상품ID
     * @param itemName 상품명
     * @param price 상품 가격
     */
    public ProductItem(String itemId, String itemName, int price) {
        setItemId(itemId);
        setItemName(itemName);
        setPrice(price);
    }

    /**
     * 상품ID를 취득한다.<br />
     * 
     * @return 상품ID
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 상품ID를 설정한다.<br />
     * 
     * @param itemId 상품ID
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 상품명을 취득한다.<br />
     * 
     * @return 상품명
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 상품명을 설정한다.<br />
     * 
     * @param itemName 상품명
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 상품 가격을 취득한다.<br />
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 상품 가격을 설정한다.<br />
     * 
     * @param price 상품 가격
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
