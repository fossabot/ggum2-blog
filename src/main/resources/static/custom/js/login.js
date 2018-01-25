var isLoginFailed = $('#errorIndicator').val();
if (isLoginFailed) {
    $.gritter.add({
        title: 'Login Failed',
        text: '로그인을 실패했습니다.<br>아이디 또는 비밀번호를 다시 확인해 주세요.',
        time: ''
    })
}

var isLogout = $('#logoutIndicator').val();
if (isLogout) {
    $.gritter.add({
        title: 'Logout',
        text: '정상적으로 로그아웃 됬습니다.',
        time: ''
    })
}