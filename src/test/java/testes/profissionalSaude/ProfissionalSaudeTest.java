package testes.profissionalSaude;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import seleniumfw.selenium.Selenium;
import seleniumfw.selenium.SeleniumImpl;
import testes.data.ProfissionalSaudeDataTest;
import testes.data.UsuarioDataTest;
import testes.dominio.ProfissionalSaude;
import testes.pages.FormProfissionalSaude;
import testes.pages.Login;
import testes.pages.Menu;

public class ProfissionalSaudeTest {

	static Selenium selenium = new SeleniumImpl();
	static final String MENSAGEM_SUCESSO = "Cadastrado com sucesso!";
	
	static Menu menu = new Menu(selenium);
	
	@BeforeClass
	public static void login() {
		Login login = new Login(selenium, UsuarioDataTest.getUsuarioPadrao());
		login.doLogin();
	}

	@AfterClass
	public static void logout() {
		menu.logout();
	}
	
	@Before
	public void goToFormProfissionalSaude() throws InterruptedException {
		Thread.sleep(2000);
		menu.goToFormProfissionalSaude();
	}
	

	@Test
	public void cadastrarPsCpfInvalido() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsCpfInvalido());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	@Test
	public void cadastrarPsSemNome() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsSemNome());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	@Test
	public void cadastrarPsSemEspecialidade() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsSemEspecialidade());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	@Test
	public void cadastrarPsSemIdProfissional() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsSemIdProfissional());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}
	
	@Test
	public void cadastrarPsSemEmail() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsSemEmail());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	@Test
	public void cadastrarPsEmailInvalido() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsEmailInvalido());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	@Test
	public void cadastrarPsSemLogin() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getPsSemLogin());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}

	//@Test
	public void cadastrarNovoProfissionalSaude() {
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ProfissionalSaudeDataTest.getProfissionalSaudeCompleto());
		formProfissionalSaude.preencheForm();		
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertTrue(sucesso);
	}
	
	@Test
	public void cadastrarPsLoginExistente() throws InterruptedException {
		ProfissionalSaude ps = ProfissionalSaudeDataTest.getProfissionalSaudeCompleto();
		FormProfissionalSaude formProfissionalSaude = new FormProfissionalSaude(selenium, ps);
		formProfissionalSaude.preencheForm();
		Boolean sucesso = selenium.getDriver().getPageSource().contains(MENSAGEM_SUCESSO);
		assertFalse(sucesso);
	}
	
}
