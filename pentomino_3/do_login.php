<?php
    // 폼에 입력된 내용을 취득한다
    $user = $_POST['user'];
    $pass = $_POST['pass'];
    
    // 패스워드를 확인한다
    if(strcmp($pass, 'webtext') == 0) {
        // 세션 개시
        session_start();
        
        // 세션 변수에 아이디를 저장한다
        $_SESSION['user'] = $user;
        
        header('Location: item_list.php');
    } else {
        // 패스워드가 틀렸을 경우
        header('Location: login_failed.html');
    }
?>
