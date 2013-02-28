<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>피자 펜토미노 - 로그인 실패</title>
</head>

<body>
<div align="center">
    <h1>피자 펜토미노</h1>
    <p>
    아이디 혹은 패스워드가 맞지 않아<br />
    로그인에 실패했습니다.
    </p>
    <html:link forward="login">다시 로그인한다</html:link>
</div>
</body>
</html:html>
