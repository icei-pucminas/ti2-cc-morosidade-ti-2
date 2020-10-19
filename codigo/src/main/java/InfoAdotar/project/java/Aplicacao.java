package InfoAdotar.project.java;

import static spark.Spark.*;



public class Aplicacao {
	
	private static AdocaoService adocao = new AdocaoService();
	
	
    public static void main(String[] args) {
        port(6789);


        post("/inserir", (request, response) -> adocao.add(request, response));

        get("/listar/:id", (request, response) -> adocao.get(request, response));

        get("/adocao/update/:id", (request, response) -> adocao.update(request, response));

        get("/adocao/delete/:id", (request, response) -> adocao.remove(request, response));

        get("/usuario", (request, response) -> adocao.getAll(request, response));
        
        
        
    }
}