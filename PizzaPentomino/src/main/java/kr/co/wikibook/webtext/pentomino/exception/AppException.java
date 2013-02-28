/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package kr.co.wikibook.webtext.pentomino.exception;

/**
 * 피자 펜토미노의 비즈니스 로직에서 발생한 예외를 나타내는 클래스<br />
 * 
 * @author y-komori
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4086079961471455447L;

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
