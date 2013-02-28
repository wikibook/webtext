/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic;

import static kr.co.wikibook.webtext.pentomino.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.co.wikibook.webtext.pentomino.logic.impl.IbatisProductLogic;
import kr.co.wikibook.webtext.pentomino.model.Cart;
import kr.co.wikibook.webtext.pentomino.model.ProductItem;
import kr.co.wikibook.webtext.pentomino.model.PurchaseItem;

/**
 * 쇼핑 장바구니를 다루는 비즈니스 로직<br />
 * 
 * @author y-komori
 */
public class CartLogic {
    // 상품 정보의 캐시
    private static Map<String, ProductItem> productItems;

    /**
     * 세션에 관계된 쇼핑 장바구니로 선택된 상품을 추가한다.<br />
     * 
     * @param session {@link HttpSession} 객체
     * @param productIds 추가할 상품 ID의 배열
     */
    public void addItems(HttpSession session, String[] productIds) {
        if (productIds == null) {
            return;
        }

        Cart cart = retrieveCart(session);
        for (String productId : productIds) {
            cart.addItem(productId, 1);
        }
    }

    /**
     * 장바구니의 내용에서 구입 상품 목록을 취득한다.<br />
     * 
     * @param session {@link HttpSession} 객체
     * @return 구입 상품 객체 목록
     */
    public List<PurchaseItem> getPurchaseItemList(HttpSession session) {
        List<PurchaseItem> result = new ArrayList<PurchaseItem>();
        Cart cart = retrieveCart(session);

        String[] itemIds = cart.getItemIds();
        for (String itemId : itemIds) {
            // 주문 개수를 취득한다
            int quantity = cart.getQuantity(itemId);

            // 구입 상품 객체를 생성한다
            ProductItem productItem = getProductItem(itemId);
            if (productItem != null) {
                PurchaseItem purchaseItem = new PurchaseItem(productItem,
                        quantity);
                result.add(purchaseItem);
            }
        }
        return result;
    }

    /**
     * 장바구니의 상품의 합계 금액을 계산하여 돌려준다.<br />
     * 
     * @param session {@link HttpSession} 객체
     * @return 합계 금액
     */
    public int calcTotal(HttpSession session) {
        int total = 0;
        List<PurchaseItem> purchaseItemList = getPurchaseItemList(session);
        for (PurchaseItem item : purchaseItemList) {
            total += item.getSubtotal();
        }
        return total;
    }

    /**
     * 세션에서 장바구니를 취득한다.<br />
     * 세션에 장바구니가 없을 경우, 새로 생성한다.
     * 
     * @param session 세션 객체
     * @return 장바구니 객체
     */
    private Cart retrieveCart(HttpSession session) {
        Object obj = session.getAttribute(CART_SESSION_KEY);
        if (obj != null) {
            return (Cart) obj;
        } else {
            // 세션에 장바구니가 없을 경우 새로 생성한다.
            Cart cart = new Cart();
            session.setAttribute(CART_SESSION_KEY, cart);
            return cart;
        }
    }

    /**
     * ID에 대응하는 {@link ProductItem} 객체를 돌려준다.<br />
     * 
     * @param itemId 상품ID
     * @return {@link ProductItem} 객체
     */
    private ProductItem getProductItem(String itemId) {
        initProductItems();

        return productItems.get(itemId);
    }

    /**
     * 상품 정보의 캐시를 초기화한다.<br />
     */
    private void initProductItems() {
        if (productItems != null) {
            return;
        }

        productItems = new HashMap<String, ProductItem>();

        ProductLogic productLogic = new IbatisProductLogic();
        List<ProductItem> productList = productLogic.getProductList();
        for (ProductItem productItem : productList) {
            String itemId = productItem.getItemId();
            productItems.put(itemId, productItem);
        }
    }
}
