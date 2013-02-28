<?php
    // 세션을 개시
    session_start();
    $user = $_SESSION['user'];
    if(strcmp($user, '') == 0) {
        header('Location: login_failed.html');
        exit();
    }
    
    
    if($_POST['itemA'] == 'checked') {
        $_SESSION['itemA']++;
    }
    if($_POST['itemB'] == 'checked') {
        $_SESSION['itemB']++;
    }
    if($_POST['itemC'] == 'checked') {
        $_SESSION['itemC']++;
    }
    if($_POST['itemD'] == 'checked') {
        $_SESSION['itemD']++;
    }
    if($_POST['itemE'] == 'checked') {
        $_SESSION['itemE']++;
    }
    
    
    header('Location: item_list.php');
?>
