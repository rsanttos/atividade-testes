package testes.pages;

import seleniumfw.selenium.Element;
import seleniumfw.selenium.ElementImpl;
import seleniumfw.selenium.PageImpl;
import seleniumfw.selenium.Selenium;

public class Menu extends PageImpl {

	final String XPATH_MENU_PESSOAL = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]";
	final String XPATH_SUBMENU_PROFISSIONAL_SAUDE = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[2]/a";
	final String XPATH_SUBMENU_PROFISSIONAL_SAUDE_NOVO = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[2]/ul/li[1]/a";
	final String XPATH_MENU_USUARIO = "//div[@style='float: right'][contains(.,'ITAMIR')]";
	final String ID_BTN_LOGOUT = "logout";
	
	Element menuPessoal;
	Element subMenuProfissionalSaude;
	Element subMenuProfissionalSaudeNovo;
	Element menuUsuario;
	Element btnLogout;
	
	public Menu(Selenium selenium) {
		super(selenium);		
	}
	
	public void goToFormProfissionalSaude() {
		this.menuPessoal = new ElementImpl(this, null, XPATH_MENU_PESSOAL);
		this.menuPessoal.click();
		this.subMenuProfissionalSaude = new ElementImpl(this, null, XPATH_SUBMENU_PROFISSIONAL_SAUDE);
		this.subMenuProfissionalSaude.click();
		this.subMenuProfissionalSaudeNovo = new ElementImpl(this, null, XPATH_SUBMENU_PROFISSIONAL_SAUDE_NOVO);
		this.subMenuProfissionalSaudeNovo.click();
	}
	
	public void logout() {
		this.menuUsuario = new ElementImpl(this, null, XPATH_MENU_USUARIO);
		this.menuPessoal.click();
		this.btnLogout = new ElementImpl(this, ID_BTN_LOGOUT);
		this.btnLogout.click();
	}
}
