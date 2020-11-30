

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
		String serverName = "ec2-52-200-48-116.compute-1.amazonaws.com";
		String mydatabase = "dchm8pkl7rucet";
		int porta = 5432;
		String username = "jtlhjlpycbhkgr";
		String password ="ef20ff046c91d1bef531408b106d8966a5298d3e3df201ce18f88bfaa0e4d9e7";
		String url = "jdbc:postgresql://"+serverName+":"+porta+"/"+mydatabase+"?user="+username+"&password="+password;
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
		
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuarios (id,nome,idade,renda,disponibilidade,email,sexo,senha) "
					       + "VALUES ("+ adocao.getId() + ", '" + adocao.getNome() + "', "  
					       + adocao.getIdade() +"," + adocao.getRenda()+ ", " 
					       + adocao.getDisponibilidade() + ", '" +adocao.getEmail() + "', '"
					       + adocao.getSexo() + "', '" +adocao.getSenha() +  "');");
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
					   + adocao.getEmail() + "', sexo = '"  + adocao.getSexo() + "', email = '"  
							   + adocao.getSenha() +  "'"
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
			st.executeUpdate("DELETE FROM tarefas WHERE id = " + id);
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
	                		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0),rs.getString("senha"));
	                
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
		Adocao[] adocao ;
		Adocao alo=null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id = " + id);		
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	
	                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
	                		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0),rs.getString("senha"));
	                alo = adocao[i];
	            	
	             }
	          }
	          st.close();
		} catch (Exception e) {	
			System.err.println(e.getMessage());
		}
		return alo;
	}
	public Adocao att(String email,int idade,String senha) {
		Adocao[] adocao = null;
		Adocao alo=null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("Update usuarios SET senha= '"+senha+"' WHERE email = '" + email + "' AND idade="+idade );		
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	if(adocao[i].getEmail()==email && adocao[i].getIdade()==idade) {
	                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
	                		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0),rs.getString("senha"));
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
      		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0),rs.getString("senha"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return adocao;
	}
	public Adocao getLogin(String email) {
		Adocao[] adocao = null;
		Adocao alo=null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE email = '" + email +"'");		
	         if(rs.next()){
	             rs.last();
	             adocao = new Adocao[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                adocao[i] = new Adocao(rs.getInt("id"), rs.getString("nome"), 
      		                  rs.getInt("idade"),rs.getInt("renda"),rs.getInt("disponibilidade"),rs.getString("email"), rs.getString("sexo").charAt(0),rs.getString("senha"));
		                alo= adocao[i];
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alo;
	}
	public Passo progresso(int id) {
		Passo[] passo=null;
		Passo alo= null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM tarefas WHERE id = " + id);		
	         if(rs.next()){
	             rs.last();
	             passo = new Passo[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                passo[i] = new Passo(rs.getInt("id"), rs.getBoolean("passo1"), 
		                		rs.getBoolean("passo2"),rs.getBoolean("passo3"),rs.getBoolean("passo4"),rs.getBoolean("passo5"), rs.getBoolean("passo6"),rs.getBoolean("passo7"),rs.getBoolean("passo8"),rs.getBoolean("passo9"));
		                alo= passo[i];
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return alo;
	}
	public boolean passo1(Passo passo) {
		
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO tarefas (id,passo1,passo2,passo3,passo4,passo5,passo6,passo7,passo8,passo9) "
					       + "VALUES ("+ passo.getId() + ", " + passo.isPasso1() + ", "  
					       + passo.isPasso2() +"," + passo.isPasso3()+ ", " 
					       + passo.isPasso4() + ", " +passo.isPasso5() + ", "
					       + passo.isPasso6() + ", " +passo.isPasso7() + "," + passo.isPasso8()+ ","+ passo.isPasso9()+  ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	public Passo getP(int id) {
		Passo[] passo;
		Passo alo=null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM tarefas WHERE id = " + id);		
	         if(rs.next()){
	             rs.last();
	             passo = new Passo[rs.getRow()];
	             rs.beforeFirst();
	           

	             for(int i = 0; rs.next(); i++) {
	            	
	            		passo[i] = new Passo(rs.getInt("id"), rs.getBoolean("passo1"), 
		                		rs.getBoolean("passo2"),rs.getBoolean("passo3"),rs.getBoolean("passo4"),rs.getBoolean("passo5"), rs.getBoolean("passo6"),rs.getBoolean("passo7"),rs.getBoolean("passo8"),rs.getBoolean("passo9"));
	                alo = passo[i];
	            	
	             }
	             
	          }
	          st.close();
		} catch (Exception e) {	
			System.err.println(e.getMessage());
		}
		return alo;
	}
	public boolean atualizarPasso(Passo p) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE tarefas SET passo1 = " + p.isPasso1() + ", passo2 = "  
				       + p.isPasso2() + ",passo3="+ p.isPasso3() + ", passo4 = " + p.isPasso4() + ", passo5 = "  
					   + p.isPasso5() + ", passo6 = "  + p.isPasso6() + ", passo7 = "  
							   + p.isPasso7() +  ",passo8 = "+ p.isPasso8() + ",passo9 = "+ p.isPasso9()+""
							   + " WHERE id = " + p.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
		
	

	
}