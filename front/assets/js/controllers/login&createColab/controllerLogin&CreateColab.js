const URI = "http://localhost:8080/api";
const form_login = document.querySelector('.form-login');
const form_register = document.querySelector('.form-register');

function closeFormRegister() {
    div_form_register.classList.remove('animation-show')
    div_form_register.classList.add('animation-hide');
    setTimeout(() => {
        div_form_register.classList.add('hidden');
        div_form_login.classList.add('animation-show');
        div_form_login.classList.remove('hidden');
    }, 500)
}

form_register.addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
        nome: form_register.nome.value,
        cargo: form_register.cargo.value,
        setor: form_register.setor.value,
        matricula: form_register.matricula.value,
        pin: form_register.pin.value
    }

    console.log(data);

    // await fetch(`${URI}/colaborador`, {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify(data)
    // });

    setTimeout(() => {
        closeFormRegister();
    }, 500)
})