package InfoAdotar.project.java;

public class Adocao {
	private int id;
	private String nome;
	private int idade;
	private int renda;
	private int disponibilidade;
	private String email;
	private char sexo;
	
	
	public Adocao(int id, String nome, int idade, int renda, int disponibilidade, String email,char sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.disponibilidade = disponibilidade;
		this.email = email;
		this.sexo= sexo;
	}
	@Override
	public String toString() {
		return "Adocao [id=" + id + ", nome=" + nome + ", idade=" + idade + ", renda=" + renda + ", disponibilidade="
				+ disponibilidade + ", email=" + email + ", sexo=" + sexo + "]";
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
    
}
