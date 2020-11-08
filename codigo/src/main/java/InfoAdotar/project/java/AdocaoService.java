package InfoAdotar.project.java;




import org.json.JSONArray;

import spark.Request;
import spark.Response;

public class AdocaoService {

	private AdocaoDAO adocaoDAO;
	
	public AdocaoService()  {
	
			adocaoDAO = new AdocaoDAO();
			
}
	public Object add(Request request, Response response) {
		
		adocaoDAO.conectar();
		
	
	    String[] a=request.body().split("&");
	    for(String i: a) {
	    	System.out.println(i);
	    }
		String nome = a[0].split("=")[1];
		String idade = a[1].split("=")[1];
		String renda = a[2].split("=")[1];
		String disponibilidade=a[3].split("=")[1];
		String email1= a[4].split("=")[1];
		String sexo= a[5].split("=")[1];
		String senha=a[6].split("=")[1];
		
		int id = adocaoDAO.getMaxId() + 1;
		String email= "";
        for(int i =0 ; i<email1.length();i++) {
        	if(email1.charAt(i)=='%' && email1.charAt(i+1)=='4' && email1.charAt(i+2)=='0') {
        		email+='@';
        		i++;i++;
        	}else {
        		email+=email1.charAt(i);
        	}
        }
        
		Adocao adocao = new Adocao(id, nome, Integer.parseInt(idade),Integer.parseInt(renda), Integer.parseInt(disponibilidade), email,sexo.charAt(0),senha);

		adocaoDAO.inserirUsuario(adocao);

		response.status(201); // 201 Created
		adocaoDAO.close();
		return id;
		
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
        int id = Integer.parseInt(request.params(":id"));
        
		Adocao adocao = (Adocao) adocaoDAO.get(id);

        if (adocao != null) {
        	adocao.setNome(request.queryParams("nome"));
        	adocao.setIdade(Integer.parseInt(request.queryParams("idade")));
        	adocao.setRenda(Integer.parseInt(request.queryParams("renda")));
        	adocao.setDisponibilidade(Integer.parseInt(request.queryParams("disp")));
        	adocao.setEmail(request.queryParams("email"));
        	adocao.setSexo(request.queryParams("sexo").charAt(0));
        	adocao.setSenha(request.queryParams("senha"));
        	

        	adocaoDAO.atualizarUsuario(adocao);
        	 adocaoDAO.close();
            return id;
        } else {
            response.status(404); // 404 Not found
            adocaoDAO.close();
            return "Usuario nao encontrado";
        }

	}

	public Object remove(Request request, Response response) {
		adocaoDAO.conectar();
		 int id = Integer.parseInt(request.params(":id"));
	        
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
		response.header("Content-Type", "application/json");
	    response.header("Content-Encoding", "UTF-8");
		JSONArray allProds = new JSONArray();
		String a[]= request.body().split("&");
		String email1= a[0].split("=")[1];
		String senha=a[1].split("=")[1];
		String email= "";
        for(int i =0 ; i<email1.length();i++) {
        	if(email1.charAt(i)=='%' && email1.charAt(i+1)=='4' && email1.charAt(i+2)=='0') {
        		email+='@';
        		i++;i++;
        	}else {
        		email+=email1.charAt(i);
        	}
        }
        Adocao login=adocaoDAO.getLogin(email, senha);
        allProds.put(login.toJson());
		adocaoDAO.close();
		return allProds;
		
	}

	

}
