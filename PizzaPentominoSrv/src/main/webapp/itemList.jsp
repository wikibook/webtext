<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<jsp:useBean id="user" type="java.lang.String" scope="request" />

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>피자 펜토미노 - 상품 목록</title>
</head>

<body>
<h1>피자 펜토미노 - 상품 목록</h1>

<div align="center">
    <h2><%=user %>님, 원하는 피자를 선택해 주세요</h2>

    <form>
        <table class="menu">
        <tr>
            <td><input type="checkbox" name="itemA" value="checked" /></td>
            <td>마르게리타</td>
            <td class="price">800원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemB" value="checked" /></td>
            <td>바질 토마토</td>
            <td class="price">900원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemC" value="checked" /></td>
            <td>가지 미트소스</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemD" value="checked"/></td>
            <td>앤초비 시푸드</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemE" value="checked" /></td>
            <td>치즈 밀피유</td>
            <td class="price">1,300원</td>
        </tr>
        </table>
        <input type="button" value="선택한 상품을 장바구니에 넣는다" />
    </form>
    
    <form>
        <input type="button" value="장바구니의 내용을 확인하고 주문한다" />
    </form>
    
    <form>
        <input type="button" value="로그아웃" />
    </form>
</div>

</body>
</html>
