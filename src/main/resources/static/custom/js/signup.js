window.ParsleyValidator.setLocale('ko');

//has uppercase
window.Parsley.addValidator('uppercase', {
    requirementType: 'number',
    validateString: function(value, requirement) {
        var uppercases = value.match(/[A-Z]/g) || [];
        return uppercases.length >= requirement;
    },
    messages: {
        en: 'Your password must contain at least (%s) uppercase letter.',
        ko: '패스워드는 반드시 대문자를 포함해야 합니다.'
    }
});

//has lowercase
window.Parsley.addValidator('lowercase', {
    requirementType: 'number',
    validateString: function(value, requirement) {
        var lowecases = value.match(/[a-z]/g) || [];
        return lowecases.length >= requirement;
    },
    messages: {
        en: 'Your password must contain at least (%s) lowercase letter.',
        ko: '패스워드는 반드시 소문자를 포함해야 합니다.'
    }
});

//has number
window.Parsley.addValidator('number', {
    requirementType: 'number',
    validateString: function(value, requirement) {
        var numbers = value.match(/[0-9]/g) || [];
        return numbers.length >= requirement;
    },
    messages: {
        en: 'Your password must contain at least (%s) number.',
        ko: '패스워드는 반드시 숫자를 포함해야 합니다.'
    }
});

//has special char
window.Parsley.addValidator('special', {
    requirementType: 'number',
    validateString: function(value, requirement) {
        var specials = value.match(/[^a-zA-Z0-9]/g) || [];
        return specials.length >= requirement;
    },
    messages: {
        en: 'Your password must contain at least (%s) special characters.',
        ko: '패스워드는 반드시 특수문자를 포함해야 합니다.'
    }
});

$('#frmSignup').parsley();

$('#email').on('keyup', function(e) {
    var email_retry = $('#email-retry');
    if (email_retry.val().length > 0) {
        email_retry.parsley().validate();
    }
});

$('#email-retry').on('keyup', function(e) {
    var email = $('#email');
    if (email.val().length > 0) {
        email.parsley().validate();
    }
});

$('#password').on('keyup', function(e) {
    var password_retry = $('#password-retry');
    if (password_retry.val().length > 0) {
        password_retry.parsley().validate();
    }
});

$('#password-retry').on('keyup', function(e) {
    var password = $('#password');
    if (password.val().length > 0) {
        password.parsley().validate();
    }
});
