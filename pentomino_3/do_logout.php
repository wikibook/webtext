<?php
    //세션을 파기하고 로그인 화면으로 돌아온다
    session_start();
    session_destroy();
    header('Location: login.html');
?>
