<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>피자 펜토미노 - 상품 목록</title>
</head>

<body>
<h1>피자 펜토미노 - 상품 목록</h1>

<div align="center">
    <h2><bean:write name="<%=kr.co.wikibook.webtext.pentomino.Constants.USER_INFO_SESSION_KEY %>" property="userName" scope="session"/>님, 원하는 피자를 선택해 주세요</h2>
    
    <html:form action="itemListPage">
        <table class="menu">
        <tr>
            <th>상품</th>
            <th>가격</th>
        </tr>
        <logic:iterate id="productItem" name="productList" type="kr.co.wikibook.webtext.pentomino.model.ProductItem" scope="request">
        <bean:define id="itemId" name="productItem" property="itemId" type="java.lang.String"/>
        <tr>
            <td>
                <html:multibox property="selectedItems" value="<%=itemId %>" />
                <bean:write name="productItem" property="itemName"/>
            </td>
            <td class="price"><bean:write name="productItem" property="price"/>원</td>
        </tr>    
        </logic:iterate>
        </table>
        <html:submit value="선택한 상품을 장바구니에 넣는다" />
    </html:form>

    <html:form action="cartShow">
        <html:submit value="장바구니의 내용을 확인하고 주문한다" />
    </html:form>
    
    <html:form action="logout">
        <html:submit value="로그아웃" />
    </html:form>
</div>
</body>
</html:html>
