$(document).ready(function(){
	$("#butaoSim").click(function(){
	var ok=JSON.parse(sessionStorage.getItem('TbUser'));
	var rqUrl="/delete/"+ok.id;
	var rqst= new  XMLHttpRequest();
	rqst.open('GET',rqUrl);
	rqst.send();
	window.location.href="index.html";
	alert="CONTA DELETADA COM SUCESSO";
	})
	$("#butaoNao").click(function(){
		
		window.location.href="home.html";
	})
})