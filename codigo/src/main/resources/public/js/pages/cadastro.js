//#region Controllers
//Aqui é onde se é adicionado as variaveis 
//para acessar os dados do localstorage
//Obs: a variavel userController já está definida
//então não é necessário ser declarada

//#endregion

enviarform = () => {
	
	fetch("/inserir", {
	method: "POST",
	headers: {
		"Content-Type": "application/json"
	},
	body: JSON.stringify({
        "nome": document.getElementById("cadastroNome").value,
        "idade": document.getElementById("cadastroIdade").value,
        "renda": document.getElementById("cadastroRenda").value,
		"disponibilidade":document.getElementById("cadastroDisponibilidade").value,
		"email":document.getElementById("cadastroEmail").value,
		"sexo":document.getElementById("cadastroSexo").value,
		"senha":document.getElementById("cadastroPassword").value
	}),
	redirect: "manual"
})  .then(res => res.json())
    .then(data => {
		
		if(data == 200) {
			alert("Sucesso!");
 			window.location.href="index.html";
		} else {
			alert("Algum erro ocorreu.");
		}
  })
	alert("Processando...");
}
