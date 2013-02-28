<?php
    // 캐시를 무효화한다
    header('Cache-Control: no-cache');
    
    // 쿠키의 내용을 가져온다
    $user = $_COOKIE['user'];
    $pass = $_COOKIE['pass'];
    
    // 아이디와 패스워드를 확인한다
    if(strcmp($user, 'honggd') != 0 || strcmp($pass, 'webtext') != 0) {
        // 아이디와 패스워드가 틀렸을 경우
        setcookie("user", "", time() - 3600);
        setcookie("pass", "", time() - 3600);
        header('Location: login_failed.html');
        exit();
    }
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel=stylesheet type="text/css" href="../pentomino.css">
    <title>피자 펜토미노 상품목록</title>
</head>
<body>


<div align="center">
    <h1><?php echo htmlspecialchars("$user") ?>님, 원하시는 피자를 선택하세요</h1>

    <form action="item_list.php">
        <table class="menu" border="0" cellspacing="1">
        <tr>
            <th>상품</th>
            <th>가격</th>
        </tr>
        <tr>
            <td><input type="checkbox" />상품A</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" />상품B</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" />상품C</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" />상품D</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" />상품E</td>
            <td class="price">1,000원</td>
        </tr>
        </table>
        <input type="submit" value="선택한 상품을 장바구니에 넣는다" />
    </form>
    
    <form action="cart.html">
        <input type="submit" value="장바구니의 내용을 확인하고 주문한다" />
    </form>
    
    <form action="do_logout.php">
        <input type="submit" value="로그아웃" />
    </form>
</div>

</body>
</html>
