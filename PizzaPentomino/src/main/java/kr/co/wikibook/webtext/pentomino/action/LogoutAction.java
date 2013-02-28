/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.action;

import static kr.co.wikibook.webtext.pentomino.Constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 로그아웃 처리를 위한 액션입니다.<br />
 * 
 * @author y-komori
 */
public class LogoutAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 세션에서 로그인 중인 유저의 정보를 삭제
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(USER_INFO_SESSION_KEY);
            session.removeAttribute(CART_SESSION_KEY);
        }
        return mapping.findForward("success");
    }
}
