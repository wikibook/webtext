/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.model;

import java.io.Serializable;

/**
 * 구입 상품 정보를 보존 및 유지하는 클래스<br />
 * 
 * @author y-komori
 */
public class PurchaseItem implements Serializable {
    private static final long serialVersionUID = 653022201097807562L;

    // 상품ID
    private String itemId;

    // 상품명
    private String itemName;

    // 상품가격
    private int price;

    // 주문 개수
    private int quantity;

    // 소계
    private int subtotal;

    /**
     * {@link PurchaseItem} 를 구축한다.<br />
     * 
     * @param productItem 상품 정보 객체
     * @param quantity 개수
     */
    public PurchaseItem(ProductItem productItem, int quantity) {
        this.itemId = productItem.getItemId();
        this.itemName = productItem.getItemName();
        this.price = productItem.getPrice();
        this.quantity = quantity;
        this.subtotal = price * quantity;
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
     * 상품명을 취득한다.<br />
     * 
     * @return 상품명
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 상품 가격을 취득한다.<br />
     * 
     * @return 상품 가격
     */
    public int getPrice() {
        return price;
    }

    /**
     * 주문 개수를 취득한다.<br />
     * 
     * @return 주문 개수
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 소계를 취득한다.<br />
     * 
     * @return 소계
     */
    public int getSubtotal() {
        return subtotal;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", itemId, itemName, price,
                quantity, subtotal);
    }
}
