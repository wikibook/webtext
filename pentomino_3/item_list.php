<?php
    // 세션을 개시
    session_start();
    $user = $_SESSION['user'];
    if(strcmp($user, '') == 0) {
        header('Location: login_failed.html');
        exit();
    }
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel=stylesheet type="text/css" href="../pentomino.css">
    <title>피자 펜토미노 상품 목록</title>
</head>
<body>

<h1>피자 펜토미노 상품 목록</h1>

<div align="center">
    <h2><?php echo htmlspecialchars("$user") ?>님, 원하는 피자를 선택해 주세요</h2>

    <form action="do_item_list.php" method="post">
        <table class="menu" border="0" cellspacing="1">
        <tr>
            <th>상품</th>
            <th>가격</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemA" value="checked" />마르게리타</td>
            <td class="price">800원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemB" value="checked" />바질 토마토</td>
            <td class="price">900원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemC" value="checked" />가지 미트소스</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemD" value="checked"/>앤초비 시푸드</td>
            <td class="price">1,000원</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="itemE" value="checked" />치즈 밀피유</td>
            <td class="price">1,300원</td>
        </tr>
        </table>
        <input type="submit" value="선택한 상품을 장바구니에 넣는다" />
    </form>
    
    <form action="cart.php">
        <input type="submit" value="장바구니의 내용을 확인하고 주문한다" />
    </form>
    
    <form action="do_logout.php">
        <input type="submit" value="로그아웃" />
    </form>
</div>

</body>
</html>
