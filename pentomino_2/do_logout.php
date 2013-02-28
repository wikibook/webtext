<?php
    // 쿠키를 제거하고 로그인 화면으로 돌아간다
    setcookie("user", "", time() - 3600);
    setcookie("pass", "", time() - 3600);
    header('Location: login.html');
?>