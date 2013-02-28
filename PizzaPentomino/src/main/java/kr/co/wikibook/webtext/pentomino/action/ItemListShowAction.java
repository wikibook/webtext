/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.wikibook.webtext.pentomino.logic.ProductLogic;
import kr.co.wikibook.webtext.pentomino.logic.impl.IbatisProductLogic;
import kr.co.wikibook.webtext.pentomino.model.ProductItem;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 상품 목록 화면을 표시하기 위한 액션입니다.<br />
 * 
 * @author y-komori
 */
public class ItemListShowAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ProductLogic productLogic = new IbatisProductLogic();
        List<ProductItem> productList = productLogic.getProductList();

        request.setAttribute("productList", productList);

        return mapping.findForward("show");
    }
}
