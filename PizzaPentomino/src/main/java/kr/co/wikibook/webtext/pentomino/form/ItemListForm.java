/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * 선택된 상품 목록을 보관 및 유지하기 위한 액션 폼 빈<br />
 * 
 * @author y-komori
 */
public class ItemListForm extends ActionForm {

    private static final long serialVersionUID = 5067407054491876193L;

    // 선택된 상품 ID의 배열
    private String[] selectedItems;

    /**
     * 선택된 상품 ID의 배열을 취득한다.<br />
     * 
     * @return 선택된 ID의 배열
     */
    public String[] getSelectedItems() {
        return selectedItems;
    }

    /**
     * 선택된 상품 ID의 배열을 설정한다.<br />
     * 
     * @param selectedItems 선택된 상품ID의 배열
     */
    public void setSelectedItems(String[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    /* (non-Javadoc)
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        selectedItems = null;
    }

}
