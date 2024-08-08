const URI = "http://localhost:8080/api";
const form_login = document.querySelector('.form-login');
const form_register = document.querySelector('.form-register');

// REGISTRAR USUARIO
form_register.addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
        nome: form_register.nome.value,
        cargo: form_register.cargo.value,
        setor: form_register.setor.value,
        matricula: form_register.matricula.value,
        pin: form_register.pin.value
    }

    try {
        await fetch(`${URI}/colaborador`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
    
        if (confirm("USUÁRIO CRIADO COM SUCESSO!")) {
            form_register.reset();
            closeFormRegister();
        }
        
    } catch (error) {
        alert("ERRO AO CRIAR USUÁRIO. MATRÍCULA JÁ EXISTENTE.");
    }
});


// LOGIN
form_login.addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
        matricula: form_login.usuario.value,
        pin: form_login.password.value
    }

    await fetch(`${URI}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        const token = data.token;
        console.log(token);
    }); 
    
    form_login.reset();
})