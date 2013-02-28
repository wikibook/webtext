/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import kr.co.wikibook.webtext.pentomino.logic.DBInitializer;

/**
 * 피자 펜토미노 용 데이터베이스를 준비하기 위한 서블릿<br />
 * 
 * @author y-komori
 */
public class PentominoInitializer extends HttpServlet {

    private static final long serialVersionUID = -4163413787978633823L;

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            DBInitializer.initialize();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
