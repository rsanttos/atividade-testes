package testes.pages;

import seleniumfw.selenium.Element;
import seleniumfw.selenium.ElementImpl;
import seleniumfw.selenium.PageImpl;
import seleniumfw.selenium.Selenium;
import testes.dominio.Usuario;

public class Login extends PageImpl {
	
	private static final String URL_LOGIN = "https://testessigsaude.imd.ufrn.br/sigsaude/";

	private final String ID_LOGIN = "login-username";
	private final String ID_PASSWORD = "login-password";
	private final String XPATH_FORM_LOGIN = "/html/body/div/div/div/div/div[2]/div/div/form";
	
	private Element formLogin;
	private Element inputLogin;
	private Element inputPassword;

	private Usuario usuario;
	
	public Login(Selenium selenium, Usuario usuario) {
		super(URL_LOGIN, selenium);
		this.usuario = usuario;
		this.formLogin = new ElementImpl(this, null, XPATH_FORM_LOGIN);
		this.inputLogin = new ElementImpl(this, ID_LOGIN);
		this.inputPassword = new ElementImpl(this, ID_PASSWORD);
	} 
	
	public void doLogin() {
		this.open();
		this.getSelenium().maximize();
		this.inputLogin.setValue(this.usuario.getLogin());
		this.inputPassword.setValue(this.usuario.getSenha());
		this.formLogin.submit();
	}
}
