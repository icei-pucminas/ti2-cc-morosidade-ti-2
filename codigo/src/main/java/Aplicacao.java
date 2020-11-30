

import static spark.Spark.*;



public class Aplicacao {
	
	private static AdocaoService adocao = new AdocaoService();
	private static Render render = new Render();
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
		staticFiles.location("/public");
		


		get("/", (request, response) -> render.renderContent("index.html"));
		
        post("/inserir", (request, response) -> adocao.add(request, response));
		
		get("/outroPassos/:id/:passo", (request, response) -> adocao.passosT(request, response));
		
		get("/pegPassos/:id", (request, response) -> adocao.pegPassos(request, response));
		
        //get("/listar/:id", (request, response) -> adocao.get(request, response));

        get("/delete/:id", (request, response) -> adocao.remove(request, response));

        //get("/usuario", (request, response) -> adocao.getAll(request, response));

        get("/log/:email", (request, response) -> adocao.login(request, response));

        //get("/hello", (request, response)->"Hello, world rafael");

    
   	
        
        
    }
}