package InfoAdotar.project.java;
import org.json.JSONObject;
public class Adocao {
	private int id;
	private String nome;
	private int idade;
	private int renda;
	private int disponibilidade;
	private String email;
	private char sexo;
    private String senha;
    
	public Adocao(int id, String nome, int idade, int renda, int disponibilidade, String email, char sexo,
			String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.disponibilidade = disponibilidade;
		this.email = email;
		this.sexo = sexo;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Adocao [id=" + id + ", nome=" + nome + ", idade=" + idade + ", renda=" + renda + ", disponibilidade="
				+ disponibilidade + ", email=" + email + ", sexo=" + sexo + ", senha=" + senha + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getRenda() {
		return renda;
	}

	public void setRenda(int renda) {
		this.renda = renda;
	}

	public int getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("nome", this.getNome());
		obj.put("idade", this.getIdade());
		obj.put("renda", this.getRenda());
		obj.put("email", this.getEmail());
		obj.put("sexo", this.getSexo());
		obj.put("senha", this.getSenha());
		return obj;
	}


	
    
}
