<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>POST 메서드를 이용한 매개변수 전달</title>
</head>
<body>

<h1>POST 메서드를 이용한 매개변수 전달</h1>
<?php
	$arg1 = $_POST['arg1'];
	$arg2 = $_POST['arg2'];
	$result = $arg1 + $arg2;

	echo htmlspecialchars($arg1)." + ".htmlspecialchars($arg2)." = ".htmlspecialchars($result);
?>
<br />
<a href="calc_get.html">다시 한 번 계산한다</a>

</body>
</html>