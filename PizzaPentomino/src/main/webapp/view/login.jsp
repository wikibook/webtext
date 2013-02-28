<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>피자 펜토미노 - 로그인</title>
</head>
<body>
    <h1>피자 펜토미노입니다!</h1>

    <html:form action="loginPage" styleClass="login">
        <table class="login" align="center">
	    <tr>
	        <td>아이디</td>
	        <td><html:text property="user" size="16"  value=""/></td>
	    </tr>
	    <tr>
	        <td>패스워드</td>
	        <td><html:password property="password" size="16" value=""/></td>
	    </tr>
	    </table>
	    
	    <html:submit value="로그인" />
	</html:form>

</body>
</html>
