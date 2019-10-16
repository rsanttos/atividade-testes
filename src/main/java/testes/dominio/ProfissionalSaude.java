package testes.dominio;

public class ProfissionalSaude {

	private String nome;
	private String cpf;
	private String especialidade;
	private String idProfissional;
	private String email;
	private String login;

	public ProfissionalSaude() {
		super();
	}

	public ProfissionalSaude(String nome, String cpf, String especialidade, String idProfissional, String email,
			String login) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.especialidade = especialidade;
		this.idProfissional = idProfissional;
		this.email = email;
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(String idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
