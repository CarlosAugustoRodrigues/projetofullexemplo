const div_form = document.querySelector('.div-form');
const load = document.querySelector('.load');

setTimeout(() => {
    load.classList.add('animation-hide-load');

    setTimeout(() => {
        load.classList.add('hidden');
    }, 500)

    setTimeout(() => {
        div_form.classList.remove('hidden');
    }, 1000)

}, 3500)

