package InfoAdotar.project.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdocaoDAO {

	private Connection conexao;
	
	
	public AdocaoDAO() {
		conexao = null;
	}
	
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "Adotantes";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "postgres";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirUsuario(Adocao adocao) {
		System.out.println(adocao);
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuarios (id,nome,idade,renda,disponibilidade,email,sexo) "
					       + "VALUES ("+ adocao.getId() + ", '" + adocao.getNome() + "', "  
					       + adocao.getIdade() +"," + adocao.getRenda()+ ", " 
					       + adocao.getDisponibilidade() + ", '" +adocao.getEmail() + "', '"
					       + adocao.getSexo() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarUsuario(Adocao adocao) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE jogador SET nome = '" + adocao.getNome() + "', idade = '"  
				       + adocao.getIdade() + "',renda='"+ adocao.getRenda() + "', disponibilidade = '" + adocao.getDisponibilidade() + "', email = '"  
					   + adocao.getEmail() + "', sexo = '"  + adocao.getSexo() + "'"
					   + " WHERE id = " + adocao.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirUsuario(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM usuarios WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Adocao[] getUsuario() {
		Adocao[] adocao = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
			
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();
	             
	             for(int i = 0; rs.next(); i++) {
	                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
	                		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0));
	                
	             }
	          
	          }
	          st.close();
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		return adocao;
	}
	  public int getMaxId() {
		  Adocao[] adocao = getUsuario();
		  int maior=adocao[0].getId();
		  for(int i=1;i<adocao.length;i++) {
			  if(adocao[i].getId()>maior) {
				   maior=adocao[i].getId();
			  }
		  }
		  
		  
			return maior;
		}
	public Adocao get(int id) {
		Adocao[] adocao = null;
		Adocao alo=null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT FROM usuarios WHERE id = " + id);		
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	if(adocao[i].getId()==id) {
	                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
	                		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0));
	                alo = adocao[i];
	            	}
	             }
	          }
	          st.close();
		} catch (Exception e) {	
			System.err.println(e.getMessage());
		}
		return alo;
	}


	
	public Adocao[] getUsuariosMasculinos() {
		Adocao[] adocao = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuarios.sexo LIKE 'M'");		
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
      		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return adocao;
	}
}