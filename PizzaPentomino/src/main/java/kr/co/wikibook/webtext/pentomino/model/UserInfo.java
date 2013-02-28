/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.model;

import java.io.Serializable;

/**
 * 로그인 중인 사용자의 정보를 보존 및 유지하기 위한 클래스<br />
 * 
 * @author y-komori
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -995968529508654626L;

    // 사용자 아이디
    private String userName;

    /**
     * 사용자 아이디를 취득한다. <br />
     * 
     * @return 사용자 아이디
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 사용자 아이디를 설정한다.<br />
     * 
     * @param userName 사용자 아이디
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
