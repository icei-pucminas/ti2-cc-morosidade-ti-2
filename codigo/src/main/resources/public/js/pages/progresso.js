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
function getZ(){
	var infoPasso=JSON.parse(this.responseText);
	sessionStorage.setItem('Passo',JSON.stringify(infoPasso));
	var a=JSON.parse(sessionStorage.getItem('Passo'));
	var z= document.getElementById("passosProgress");
	if(a.passo1==false){
		alert("Voce ainda nao realizou o passo 1");
		z.style.width="0%";
	}
	if(a.passo1==true){
		document.getElementById("passo1").disabled=true;
		document.getElementById("passo2").disabled=false;
		z.style.width="11%";
		var ae= document.getElementById("teste1");
		ae.innerHTML="<s><h1>Passo 1: Cadastro Na vara da infancia</h1></s>";
		var alo= document.getElementById("passo1teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
		
	}
	if(a.passo2==true){
		document.getElementById("passo2").disabled=true;
		document.getElementById("passo3").disabled=false;
		z.style.width="22%";
		var ae= document.getElementById("teste2");
		ae.innerHTML="<s><h1>Passo 2: Participação em programa de preparação para adoção</h1></s>";
		var alo= document.getElementById("passo2teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo3==true){
		document.getElementById("passo3").disabled=true;
		document.getElementById("passo4").disabled=false;
		z.style.width="33%";
		var ae= document.getElementById("teste3");
		ae.innerHTML="<s><h1>Passo 3: Avaliação da equipe interprofissional</h1></s>";
		var alo= document.getElementById("passo3teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo4==true){
		document.getElementById("passo4").disabled=true;
		document.getElementById("passo5").disabled=false;
		z.style.width="44%";
		var ae= document.getElementById("teste4");
		ae.innerHTML="<s><h1>Passo 4: Participação em programa de preparação para adoção</h1></s>";
		var alo= document.getElementById("passo4teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo5==true){
		document.getElementById("passo5").disabled=true;
		document.getElementById("passo6").disabled=false;
		z.style.width="55%";
		var ae= document.getElementById("teste5");
		ae.innerHTML="<s><h1>Passo 5: Análise do requerimento pela autoridade judiciária</h1></s>";
		var alo= document.getElementById("passo5teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo6==true){
		document.getElementById("passo6").disabled=true;
		document.getElementById("passo7").disabled=false;
		z.style.width="66%";
		var ae= document.getElementById("teste6");
		ae.innerHTML="<s><h1>Passo 6: Ingresso no Sistema Nacional de Adoção e Acolhimento</h1></s>";
		var alo= document.getElementById("passo6teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
		
	}
	if(a.passo7==true){
		document.getElementById("passo7").disabled=true;
		document.getElementById("passo8").disabled=false;
		z.style.width="77%";
		var ae= document.getElementById("teste7");
		ae.innerHTML="<s><h1>Passo 7: Ingresso no Sistema Nacional de Adoção e Acolhimento</h1></s>";
		var alo= document.getElementById("passo7teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo8==true){
		document.getElementById("passo8").disabled=true;
		document.getElementById("passo9").disabled=false;
		z.style.width="88%";
		var ae= document.getElementById("teste8");
		ae.innerHTML="<s><h1>Passo 8: O momento de construir novas relações</h1></s>";
		var alo= document.getElementById("passo8teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	if(a.passo9==true){
		document.getElementById("passo9").disabled=true;
		z.style.width="100%";
		alert("VOCE JA CONCLUIU TODOS OS PASSOS DA ADOCAO!");
		var ae= document.getElementById("teste9");
		ae.innerHTML="<s><h1>Passo 9: Uma nova família</h1></s>";
		var alo= document.getElementById("passo9teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	}
	
}
function progresso1(){
	console.log("rafael progreso");
	document.getElementById("passo1").disabled=true;
	document.getElementById("passo2").disabled=false;

	var a= document.getElementById("passosProgress");
	a.style.width="11%";
	var ae= document.getElementById("teste1");
	ae.innerHTML="<s><h1>Passo 1: Cadastro Na vara da infancia</h1></s>";
	var alo= document.getElementById("passo1teste");
	alo.innerHTML="<h1 style=color:blue>FEITO</h1>";

	
}
function progresso2(){
		document.getElementById("passo2").disabled=true;
	document.getElementById("passo3").disabled=false;
	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="22%";
	var ae= document.getElementById("teste2");
		ae.innerHTML="<s><h1>Passo 2: Participação em programa de preparação para adoção</h1></s>";
		var alo= document.getElementById("passo2teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso3(){
	document.getElementById("passo3").disabled=true;
	document.getElementById("passo4").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="33%";
	var ae= document.getElementById("teste3");
		ae.innerHTML="<s><h1>Passo 3: Avaliação da equipe interprofissional</h1></s>";
		var alo= document.getElementById("passo3teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso4(){
	document.getElementById("passo4").disabled=true;
	document.getElementById("passo5").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="44%";
	var ae= document.getElementById("teste4");
		ae.innerHTML="<s><h1>Passo 4: Participação em programa de preparação para adoção</h1></s>";
		var alo= document.getElementById("passo4teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
	
}
function progresso5(){
	document.getElementById("passo5").disabled=true;
	document.getElementById("passo6").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="55%";
		var ae= document.getElementById("teste5");
		ae.innerHTML="<s><h1>Passo 5: Análise do requerimento pela autoridade judiciária</h1></s>";
		var alo= document.getElementById("passo5teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso6(){
	document.getElementById("passo6").disabled=true;
		document.getElementById("passo7").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="66%";
	var ae= document.getElementById("teste6");
		ae.innerHTML="<s><h1>Passo 6: Ingresso no Sistema Nacional de Adoção e Acolhimento</h1></s>";
		var alo= document.getElementById("passo6teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso7(){
	document.getElementById("passo7").disabled=true;
		document.getElementById("passo8").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="77%";
	var ae= document.getElementById("teste7");
		ae.innerHTML="<s><h1>Passo 7: Ingresso no Sistema Nacional de Adoção e Acolhimento</h1></s>";
		var alo= document.getElementById("passo7teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso8(){
	document.getElementById("passo8").disabled=true;
		document.getElementById("passo9").disabled=false;

	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="88%";
		var ae= document.getElementById("teste8");
		ae.innerHTML="<s><h1>Passo 8: O momento de construir novas relações</h1></s>";
		var alo= document.getElementById("passo8teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}
function progresso9(){
	console.log("rafael progreso");
	var a= document.getElementById("passosProgress");
	a.style.width="100%";
	alert("VOCE JA CONCLUIU TODOS OS PASSOS DA ADOCAO!");
		var ae= document.getElementById("teste9");
		ae.innerHTML="<s><h1>Passo 9: Uma nova família</h1></s>";
		var alo= document.getElementById("passo9teste");
		alo.innerHTML="<h1 style=color:blue>FEITO</h1>";
	
}


$(document).ready(function(){
	console.log("rafael");
	var ok=JSON.parse(sessionStorage.getItem('TbUser'));
	var rqUrl="/pegPassos/"+ok.id;
	var rqst= new  XMLHttpRequest();
	rqst.open('GET',rqUrl);
	rqst.send();
	rqst.onload=getZ;
	let a=JSON.parse(sessionStorage.getItem('Passo'));
	

	$("#passo1").click(function(e){
		console.log("rafael");
		var requestUrl="/outroPassos/"+ok.id+"/1";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo um concluido!Parabens");
		a.passo1=true;
	    e.preventDefault();
		progresso1();
		
      
	});
	$("#passo2").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/2";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo dois concluido!Parabens");
		a.passo2=true;
		
        e.preventDefault();
		progresso2();	
	});
	$("#passo3").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/3";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo tres concluido!Parabens");
		a.passo3=true;
	
        e.preventDefault();
		progresso3();	
	});
	
	$("#passo4").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/4";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo quatro concluido!Parabens");
		a.passo4=true;
		
        e.preventDefault();
		progresso4();	
	});
	$("#passo5").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/5";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo cinco concluido!Parabens");
		a.passo5=true;
	
        e.preventDefault();
		progresso5();	
	});
	$("#passo6").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/6";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo seis concluido!Parabens");
		a.passo6=true;
		
        e.preventDefault();
		progresso6();	
	});
	$("#passo7").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/7";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo sete concluido!Parabens");
		a.passo7=true;

        e.preventDefault();
		progresso7();	
	});
	$("#passo8").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/8";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo oito concluido!Parabens");
		a.passo8=true;
	
        e.preventDefault();
		progresso8();	
	});
	$("#passo9").click(function(e){
		console.log("rafael");
		
        var requestUrl="/outroPassos/"+ok.id+"/9";
        var request = new XMLHttpRequest();
        request.open('GET', requestUrl);
        request.send();
		alert("Passo nove concluido!Parabens");
		a.passo9=true;
		
        e.preventDefault();
		progresso9();	
	});

	
});