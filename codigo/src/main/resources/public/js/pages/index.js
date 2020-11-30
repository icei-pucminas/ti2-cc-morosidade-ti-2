//#region Controllers

var faqController;
var passoController;
var comunidadeController;




function requesta(){
    console.log("cheguei");
    var info= JSON.parse(this.responseText);
    var infoFiltrado={
		"email":info.email,
        "id":info.id, 
        "nome":info.nome
    };
    
    var em= $("#loginFormEmail").val();
    var sen=$("#loginFormPassword").val();
    if(info.email==em && info.senha==sen){
		sessionStorage.setItem('TbUser',JSON.stringify(infoFiltrado));
        window.open("home.html","_self");
    }else{
        alert("Senha ou email incorretos");
    }

}

$(document).ready(function () {
    $("#loginForm").submit(function (e) {
        var em= $("#loginFormEmail").val();
        var requestUrl="/log/"+em;
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
        request.onload=requesta;
        e.preventDefault();
 
    });


});

