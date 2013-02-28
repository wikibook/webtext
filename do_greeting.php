<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>한글로 매개변수 전달</title>
</head>
<body>

<h1>한글로 매개변수 전달</h1>

<?php
	$name = $_GET['name'];

	echo "안녕하세요, ".htmlspecialchars($name)." 씨";
?>
<br />
<a href="greeting.html">다시 한 번 인사한다</a>

</body>
</html>