






import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class AdocaoService {

	private AdocaoDAO adocaoDAO;
	
	public AdocaoService()  {
	
			adocaoDAO = new AdocaoDAO();
			
}
	public Object add(Request request, Response response) {
		System.out.println(request.body());
		adocaoDAO.conectar();
		int status;
	
	    String[] a=request.body().split("&");
	    for(String i: a) {
	    	System.out.println("oi="+i);
	    }  
	    Gson gson = new Gson();
	    
	    AdocaoModel adoc= gson.fromJson(request.body(),AdocaoModel.class);
	    
		int id = adocaoDAO.getMaxId() + 1;
	
        
		Adocao adocao = new Adocao(id,adoc.nome, adoc.idade,adoc.renda, adoc.disponibilidade, adoc.email,adoc.sexo,adoc.senha);
		try{
			adocaoDAO.inserirUsuario(adocao);
			System.out.println("chego aq");
			Passo passo = new Passo(id,false,false,false,false,false,false,false,false,false);
			adocaoDAO.passo1(passo);
			System.out.println("chego aq tb");
			status=200;
		}catch(Exception e) {
		    status=500;
		}

		response.status(status); // 201 Created
		adocaoDAO.close();
		System.out.println(gson.toJson(status));
		return gson.toJson(status);
		
	}


	public Object get(Request request, Response response) {
		adocaoDAO.conectar();
		int id = Integer.parseInt(request.params(":id"));
		
		Adocao Adocao = (Adocao) adocaoDAO.get(id);
		
		if (Adocao != null) {
    	    response.header("Content-Type", "application/xml");
    	    response.header("Content-Encoding", "UTF-8");
    	    adocaoDAO.close();
            return "<adocao>\n" + 
            		"\t<is> " + Adocao.getId() + "</id>\n" +
            		"\t<nome> " + Adocao.getNome() + "</nome>\n" +
            		"\t<idade> " + Adocao.getIdade() + "</idade>\n" +
            		"\t<renda> " + Adocao.getRenda() + "</renda>\n" +
            		"\t<disponibilidade> " + Adocao.getDisponibilidade() + "</disponibilidade>\n" +
            		"\t<email> " + Adocao.getEmail() + "</email>\n" +
            		"\t<sexo> " + Adocao.getSexo() + "</sexo>\n" +
            		"\t<senha>" + Adocao.getSenha() + "</senha>\n" +
            		"</adocao>\n";
        } else {
            response.status(404); // 404 Not found
            adocaoDAO.close();
            return "Produto " + id + " não encontrado.";
        }

	}

	public Object update(Request request, Response response) {
		adocaoDAO.conectar();
		System.out.println("oiiiii");
		String email= request.params(":email");
		System.out.println(email);
		int idade =Integer.parseInt(request.params(":idade"));
		String senha=request.params(":senha");
		Adocao adocao = (Adocao) adocaoDAO.att(email,idade,senha);
		response.status(201); // 201 Created
        if (adocao != null) {
        	 
        	 adocaoDAO.close();
             return "feito";
        } else {
            response.status(404); // 404 Not found
            adocaoDAO.close();
            return "Usuario nao encontrado";
        }

	}

	public Object remove(Request request, Response response) {
		adocaoDAO.conectar();
		 int id = Integer.parseInt(request.params(":id"));
	     int status;
			Adocao adocao = (Adocao) adocaoDAO.get(id);

        if (adocao != null) {
 
            adocaoDAO.excluirUsuario(id);

            response.status(200); // success
            adocaoDAO.close();
        	return id;
        } else {
            response.status(404); // 404 Not found
            adocaoDAO.close();
            return "Usuario nao encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		adocaoDAO.conectar();
		StringBuffer returnValue = new StringBuffer("<adocao type=\"array\">");
		for (Adocao adocao1 : adocaoDAO.getUsuario()) {
			
			returnValue.append("\n<bemdeconsumo>\n" + 
					"\t<id> " + adocao1.getId() + "</id>\n" +
            		"\t<nome> " + adocao1.getNome() + "</nome>\n" +
            		"\t<idade> " + adocao1.getIdade() + "</idade>\n" +
            		"\t<renda> " + adocao1.getRenda() + "</renda>\n" +
            		"\t<disponibilidade> " + adocao1.getDisponibilidade() + "</disponibilidade>\n" +
            		"\t<email> " + adocao1.getEmail() + "</email>\n" +
            		"\t<sexo> " + adocao1.getSexo() + "</sexo>\n" +
            		"\t<senha>" + adocao1.getSenha() + "</senha>\n" +
            		"</adocao>\n");
		}
		returnValue.append("</adocao>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
	    adocaoDAO.close();
		return returnValue.toString();

	} 
	public Object login(Request request , Response response) {
		
		adocaoDAO.conectar();
		
		String email= request.params(":email");
		
	
		Adocao user = (Adocao) adocaoDAO.getLogin(email);
		
		
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		response.header("Access-Control-Allow-Origin","*");
			
		if (user != null) {
			
			adocaoDAO.close();
			return user.toJson();
		} else {
			
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			
			adocaoDAO.close();
			return null;
		}
			
	
	}

	 public Object passosT(Request request, Response response){
		 System.out.println("chegou aq");
		 adocaoDAO.conectar();
		 int id=Integer.parseInt(request.params(":id"));
		 int passo=Integer.parseInt(request.params(":passo"));
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		response.header("Access-Control-Allow-Origin","*");	
		 Passo p = (Passo) adocaoDAO.getP(id);
		 if(p!=null) {
			 if(passo==1) {
				 p.setPasso1(true);
			 }else if(passo==2) {
				 p.setPasso2(true);
			 }else if(passo==3) {
				 p.setPasso3(true);
			 }else if(passo==4) {
				 p.setPasso4(true);
			 }else if(passo==5) {
				 p.setPasso5(true);
			 }else if(passo==6) {
				 p.setPasso6(true);
			 }else if(passo==7) {
				 p.setPasso7(true);
			 }else if(passo==8) {
				 p.setPasso8(true);
			 }else if(passo==9) {
				 p.setPasso9(true);
			 }
		 adocaoDAO.atualizarPasso(p);
		
		 adocaoDAO.close();
		 return id;
		 }else {
	            response.status(404); // 404 Not found
	            adocaoDAO.close();
	            return "Usuario nao encontrado";
	        
		 }
	 }
	 public Object pegPassos(Request request, Response response){
		 adocaoDAO.conectar();
		 int id=Integer.parseInt(request.params(":id"));
		 response.header("Content-Type", "application/json");
		 response.header("Content-Encoding", "UTF-8");
		 response.header("Access-Control-Allow-Origin","*");
		 Passo p=(Passo) adocaoDAO.getP(id);
		 if(p!=null) {
			adocaoDAO.close();
			return p.toJson();
			 
		 }else {
			 	response.status(404); // NOT FOUND
				response.redirect("/notfound.html");
				
				adocaoDAO.close();
				return null;
		 }
		 
	 }
	

}
