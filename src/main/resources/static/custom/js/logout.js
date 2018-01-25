function logout() {
    var logoutForm = $('#logout');
    logoutForm.action = "/logout";
    logoutForm.method = "POST";
    logoutForm.submit();

}