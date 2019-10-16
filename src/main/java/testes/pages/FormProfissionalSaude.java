package testes.pages;

import java.util.Objects;

import seleniumfw.selenium.Element;
import seleniumfw.selenium.ElementImpl;
import seleniumfw.selenium.PageImpl;
import seleniumfw.selenium.Selenium;
import testes.dominio.ProfissionalSaude;

public class FormProfissionalSaude extends PageImpl {

	final String ID_INPUT_CPF = "inputCPF";
	final String ID_INPUT_NOME = "inputNome";
	final String ID_SELECT_ESPECIALIDADE = "selectEspecialidade";
	final String ID_INPUT_ID_PROFISSIONAL = "inputIdentidadeProfissional";
	final String ID_INPUT_EMAIL = "inputEmail";
	final String ID_INPUT_LOGIN = "inputLogin";
	final String ID_BTN_CADASTRAR = "cadastrarColaborador";
	
	Element inputCpf;
	Element inputNome;
	Element selectEspecialidade;
	Element inputIdProfissional;
	Element inputEmail;
	Element inputLogin;
	Element btnCadastrar;
	
	ProfissionalSaude profissionalSaude;
	
	public FormProfissionalSaude(Selenium selenium, ProfissionalSaude profissionalSaude) {
		super(selenium);
		this.profissionalSaude = profissionalSaude;
		this.inputCpf = new ElementImpl(this, ID_INPUT_CPF);
		this.inputNome = new ElementImpl(this, ID_INPUT_NOME);
		this.selectEspecialidade = new ElementImpl(this, ID_SELECT_ESPECIALIDADE);
		this.inputIdProfissional = new ElementImpl(this, ID_INPUT_ID_PROFISSIONAL);
		this.inputEmail = new ElementImpl(this, ID_INPUT_EMAIL);
		this.inputLogin = new ElementImpl(this,  ID_INPUT_LOGIN);
		this.btnCadastrar = new ElementImpl(this, ID_BTN_CADASTRAR);
	}
	
	public void preencheForm() {
		if(!Objects.isNull(this.profissionalSaude.getCpf())) {
			this.inputCpf.setValue(this.profissionalSaude.getCpf());			
		}
		if(!Objects.isNull(this.profissionalSaude.getNome())) {
			this.inputNome.setValue(this.profissionalSaude.getNome());			
		}
		if(!Objects.isNull(this.profissionalSaude.getEspecialidade())) {
			this.selectEspecialidade.selectTextoVisivel(this.profissionalSaude.getEspecialidade());			
		}
		if(!Objects.isNull(this.profissionalSaude.getIdProfissional())) {
			this.inputIdProfissional.setValue(this.profissionalSaude.getIdProfissional());
		}
		if(!Objects.isNull(this.profissionalSaude.getEmail())) {
			this.inputEmail.setValue(this.profissionalSaude.getEmail());
		}
		if(!Objects.isNull(this.profissionalSaude.getLogin())) {
			this.inputLogin.setValue(this.profissionalSaude.getLogin());			
		}
		this.btnCadastrar.click();
	}
}
