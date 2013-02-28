/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.wikibook.webtext.pentomino.logic.CartLogic;
import kr.co.wikibook.webtext.pentomino.model.PurchaseItem;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 장바구니 화면을 표시하기 위한 액션입니다.<br />
 * 
 * @author y-komori
 */
public class CartShowAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 장바구니에서 구입 상품 정보를 꺼낸다
        CartLogic cartLogic = new CartLogic();
        HttpSession session = request.getSession();

        List<PurchaseItem> purchaseItemList = cartLogic
                .getPurchaseItemList(session);

        int total = cartLogic.calcTotal(session);

        // 요청 스코프에 구입 상품 정보를 저장한다
        request.setAttribute("purchaseItemList", purchaseItemList);

        // 요청 스코프에 합계 금액을 저장한다
        request.setAttribute("total", Integer.toString(total));

        return mapping.findForward("success");
    }
}
