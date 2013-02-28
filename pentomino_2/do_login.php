<?php
    // 폼에 입력된 내용을 가져온다
    $user = $_POST['user'];
    $pass = $_POST['pass'];

    // 아이디와 패스워드를 확인한다
    if(strcmp($user,'honggd') == 0 && strcmp($pass, 'webtext') == 0) {
        // 아이디와 패스워드가 정확할 경우
        setcookie("user", $user);
        setcookie("pass", $pass);
        header('Location: item_list.php');
    } else {
        // 아이디와 패스워드가 틀렸을 경우
        header('Location: login_failed.html');
    }
?>