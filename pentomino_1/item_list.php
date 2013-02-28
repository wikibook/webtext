<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel=stylesheet type="text/css" href="../pentomino.css">
    <title>피자 펜토미노 상품 목록</title>
</head>
<body>


<div align="center">
    <h1>honggd님, 원하는 피자를 선택해 주세요</h1>

    <form action="item_list.html">
        <table class="menu" border="0" cellspacing="1">
        <tr>
            <th>품명</th>
            <th>단가</th>
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
    
    <form action="login.html">
        <input type="submit" value="로그아웃" />
    </form>
</div>

</body>
</html>
