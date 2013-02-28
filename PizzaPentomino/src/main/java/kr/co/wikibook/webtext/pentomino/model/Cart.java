/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 쇼핑 장바구니를 나타내는 모델<br />
 * 
 * @author y-komori
 */
public class Cart {
    // 구입 상품 정보(상품ID와 개수의 맵)
    private Map<String, Integer> cart = new HashMap<String, Integer>();

    /**
     * 장바구니에 상품을 추가한다.<br />
     * 
     * @param itemId 상품ID
     * @param quantity 주문 개수
     */
    public void addItem(String itemId, int quantity) {
        Integer currentQt = cart.get(itemId);
        if (currentQt == null) {
            currentQt = new Integer(0);
        }

        cart.put(itemId, new Integer(currentQt.intValue() + quantity));
    }

    /**
     * 장바구니에 보관돼 있는 상품ID의 배열을 돌려준다.<br />
     * 
     * @return 상품ID의 배열
     */
    public String[] getItemIds() {
        Set<String> itemIdSet = cart.keySet();
        String[] result = new String[itemIdSet.size()];
        itemIdSet.<String> toArray(result);
        Arrays.sort(result);
        return result;
    }

    /**
     * 상품ID에 대한 주문 개수를 돌려준다.<br />
     * 
     * @param itemId 상품ID
     * @return 주문 개수
     */
    public int getQuantity(String itemId) {
        if (itemId == null) {
            return 0;
        }

        Integer quantity = cart.get(itemId);
        if (quantity != null) {
            return quantity.intValue();
        } else {
            return 0;
        }
    }
}
