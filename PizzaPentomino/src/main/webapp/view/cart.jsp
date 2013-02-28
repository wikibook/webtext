<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<jsp:useBean id="total" type="java.lang.String" scope="request" />

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>피자 펜토미노 - 장바구니 목록</title>
</head>

<body>
<h1>피자 펜토미노 - 장바구니 목록</h1>

<div align="center">
    <h2><bean:write name="<%=kr.co.wikibook.webtext.pentomino.Constants.USER_INFO_SESSION_KEY %>" property="userName" scope="session"/>님의 장바구니 안의 상품은 다음과 같습니다</h2>
    
    <html:form action="complete">
        <table class="menu">
        <tr>
            <th>품명</th>
            <th>단가</th>
            <th>주문수</th>
            <th>금액</th>
        </tr>
        <logic:iterate id="purchaseItem" name="purchaseItemList" type="kr.co.wikibook.webtext.pentomino.model.PurchaseItem" scope="request">
        <tr>
            <td><bean:write name="purchaseItem" property="itemName"/></td>
            <td class="price"><bean:write name="purchaseItem" property="price"/></td>
            <td class="price"><bean:write name="purchaseItem" property="quantity"/>개</td>
            <td class="price"><bean:write name="purchaseItem" property="subtotal"/>원</td>
        </tr>    
        </logic:iterate>
        <tr>
            <th colspan="3" align="right">합계 금액</th>
            <td class="price"><%=total %>원</td>
        </tr>
        </table>
        <html:submit value="이 내용으로 주문한다" />
    </html:form>

    <html:form action="itemListShow">
        <html:submit value="주문을 다시 한다" />
    </html:form>
</div>
</body>
</html:html>
