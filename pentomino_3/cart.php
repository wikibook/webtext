<?php
    //세션을 개시
    session_start();
    $user = $_SESSION['user'];
    if($user == '') {
        header('Location: login_failed.html');
        exit();
    }
    
    $itemAnum = $_SESSION['itemA'];
    $itemAprice = 800 * $itemAnum;
    $itemBnum = $_SESSION['itemB'];
    $itemBprice = 900 * $itemBnum;
    $itemCnum = $_SESSION['itemC'];
    $itemCprice = 1000 * $itemCnum;
    $itemDnum = $_SESSION['itemD'];
    $itemDprice = 1000 * $itemDnum;
    $itemEnum = $_SESSION['itemE'];
    $itemEprice = 1300 * $itemEnum;
    
    $total = $itemAprice + $itemBprice + $itemCprice + $itemDprice + $itemEprice;
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel=stylesheet type="text/css" href="../pentomino.css">
    <title>피자 펜토미노 장바구니</title>
</head>
<body>

<h1>피자 펜토미노 장바구니</h1>

<div align="center">
    <h2><?php echo"$user" ?>님의 장바구니 안의 상품은 다음과 같습니다</h2>

    <form action="complete.html">
        <table class="menu">
        <tr>
            <th>품명</th>
            <th>단가</th>
            <th>주문 수</th>
            <th>금액</th>
        </tr>
        
        <tr>
            <td>마르게리타</td>
            <td class="price">800원</td>
            <td class="price"><?php echo "$itemAnum" ?>개</td>
            <td class="price"><?php echo "$itemAprice" ?>원</td>
        </tr>
        <tr>
            <td>바질 토마토</td>
            <td class="price">900원</td>
            <td class="price"><?php echo "$itemBnum" ?>개</td>
            <td class="price"><?php echo "$itemBprice" ?>원</td>
        </tr>
        <tr>
            <td>가지 미트소스</td>
            <td class="price">1,000원</td>
            <td class="price"><?php echo "$itemCnum" ?>개</td>
            <td class="price"><?php echo "$itemCprice" ?>원</td>
        </tr>
        <tr>
            <td>앤초비 시푸드</td>
            <td class="price">1,000원</td>
            <td class="price"><?php echo "$itemDnum" ?>개</td>
            <td class="price"><?php echo "$itemDprice" ?>원</td>
        </tr>
        <tr>
            <td>치즈 밀피유</td>
            <td class="price">1,300원</td>
            <td class="price"><?php echo "$itemEnum" ?>개</td>
            <td class="price"><?php echo "$itemEprice" ?>원</td>
        </tr>
        <tr>
            <th colspan="3" align="right">합계 금액</th>
            <td class="price"><?php echo "$total" ?>원</td>
        </tr>
        </table>
        <input type="submit" value="이 내용으로 주문한다" />
    </form>
    
    <form action="item_list.php">
        <input type="submit" value="주문을 다시 한다" />
    </form>
</div>

</body>
</html>
