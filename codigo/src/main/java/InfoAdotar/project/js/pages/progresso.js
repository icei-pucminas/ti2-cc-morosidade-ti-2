function desabilitar(){
    var passo1 = document.getElementById('passo1');
    var passo2 = document.getElementById('passo2');
    var passo3 = document.getElementById('passo3');
    var passo4 = document.getElementById('passo4');
    var passo5 = document.getElementById('passo5');
    var passo6 = document.getElementById('passo6');
    var passo7 = document.getElementById('passo7');
    var passo8 = document.getElementById('passo8');
    var passo9 = document.getElementById('passo9');

    if(passo1.checked == false){
        passo2.disabled = true;
        passo3.disabled = true;
        passo4.disabled = true;
        passo5.disabled = true;
        passo6.disabled = true;
        passo7.disabled = true;
        passo8.disabled = true;
        passo9.disabled = true;
    }

 }

 function habilitar(){
    var passo1 = document.getElementById('passo1');
    var passo2 = document.getElementById('passo2');
    var passo3 = document.getElementById('passo3');
    var passo4 = document.getElementById('passo4');
    var passo5 = document.getElementById('passo5');
    var passo6 = document.getElementById('passo6');
    var passo7 = document.getElementById('passo7');
    var passo8 = document.getElementById('passo8');
    var passo9 = document.getElementById('passo9');

    if(passo1.checked == true)
    {
        passo2.disabled = false;
    }

    if(passo2.checked == true)
    {
        passo3.disabled = false;
    }

    if(passo3.checked == true)
    {
        passo4.disabled = false;
    }

    if(passo4.checked == true)
    {
        passo5.disabled = false;
    }

    if(passo5.checked == true)
    {
        passo6.disabled = false;
    }

    if(passo6.checked == true)
    {
        passo7.disabled = false;
    }

    if(passo7.checked == true)
    {
        passo8.disabled = false;
    }

    if(passo8.checked == true)
    {
        passo9.disabled = false;
    }

 }