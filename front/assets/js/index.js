const div_form_login = document.querySelector('.div-form');
const div_form_register = document.querySelector('.div-form-register');
const div_form_password = document.querySelector('.div-form-change-password')
const load = document.querySelector('.load');

function loading() {
    setTimeout(() => {
        load.classList.add('animation-hide');
        load.classList.remove('animation-load');
        
        setTimeout(() => {
            load.classList.add('hidden');
        }, 400)
    
        setTimeout(() => {
            div_form_login.classList.add('animation-show');
            div_form_login.classList.remove('hidden');
        }, 1000)
    
    }, 4000)
}

function openFormRegister() {
    div_form_login.classList.remove('animation-show');
    div_form_login.classList.add('animation-hide');
    setTimeout(() => {
        div_form_login.classList.add('hidden');
        div_form_register.classList.add('animation-show');
        div_form_register.classList.remove('hidden');
    }, 500)
}
function openFormChangePassword() {
    div_form_login.classList.remove('animation-show');
    div_form_login.classList.add('animation-hide');
    setTimeout(() => {
        div_form_login.classList.add('hidden');
        div_form_password.classList.add('animation-show');
        div_form_password.classList.remove('hidden');
    }, 500)
}

function closeFormRegister() {
    div_form_register.classList.remove('animation-show')
    div_form_register.classList.add('animation-hide');
    setTimeout(() => {
        div_form_register.classList.add('hidden');
        div_form_login.classList.add('animation-show');
        div_form_login.classList.remove('hidden');
    }, 500)
}
function closeFormChangePassword() {
    div_form_password.classList.remove('animation-show')
    div_form_password.classList.add('animation-hide');
    setTimeout(() => {
        div_form_password.classList.add('hidden');
        div_form_login.classList.add('animation-show');
        div_form_login.classList.remove('hidden');
    }, 500)
}