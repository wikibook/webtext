/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.wikibook.webtext.pentomino.form.ItemListForm;
import kr.co.wikibook.webtext.pentomino.logic.CartLogic;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 상품 목록 화면에서 장바구니에 상품을 추가하는 조작을 위한 액션입니다<br />
 * 
 * @author y-komori
 */
public class ItemListPageAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 폼에서 선택된 상품의 ID를 꺼낸다
        ItemListForm itemListForm = (ItemListForm) form;
        String[] selectedItems = itemListForm.getSelectedItems();

        // 세션 객체를 취득한다
        HttpSession session = request.getSession();

        // 장바구니에 상품을 추가한다
        CartLogic cartLogic = new CartLogic();
        cartLogic.addItems(session, selectedItems);

        itemListForm.reset(mapping, request);
        return mapping.findForward("success");
    }
}
