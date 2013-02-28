/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.logic;

/**
 * 로그인 처리를 위한 비즈니스 로직<br />
 * 
 * @author y-komori
 */
public class LoginLogic {
    /**
     * 로그인 여부를 체크한다.<br />
     * 
     * @param user 아이디
     * @param password 패스워드
     * @return 로그인 OK일 경우,<code>true</code>
     */
    public boolean loginCheck(final String user, final String password) {
        // 패스워드가「webtext」이면 로그인을 허가한다
        if ("webtext".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
