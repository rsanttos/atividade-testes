package testes.data;

import java.util.Random;

import testes.dominio.ProfissionalSaude;

public class ProfissionalSaudeDataTest {

	public static ProfissionalSaude getProfissionalSaudeCompleto() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("926.946.320-68");
		ps.setLogin("testes-residencia");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional("idProfissional");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}

	public static ProfissionalSaude getPSSucesso() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("992.161.610-27");
		ps.setLogin("residedencia-lo");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional("idProfiss333");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}
	
	public static ProfissionalSaude getPsCpfInvalido() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("109.000.999-98");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional(getValorAleatorio());
		ps.setLogin(getValorAleatorio() + "login");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}

	public static ProfissionalSaude getPsSemNome() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("483.825.760-01");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional(getValorAleatorio());
		ps.setLogin(getValorAleatorio() + "login");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}

	public static ProfissionalSaude getPsSemEspecialidade() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("797.071.580-00");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional(getValorAleatorio());
		ps.setLogin(getValorAleatorio() + "login");
		return ps;
	}

	public static ProfissionalSaude getPsSemIdProfissional() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("052.480.500-81");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setLogin(getValorAleatorio() + "login");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}
	
	public static ProfissionalSaude getPsSemEmail() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("566.879.800-33");
		ps.setNome("Ramon Teste");
		ps.setIdProfissional(getValorAleatorio());
		ps.setLogin(getValorAleatorio() + "login");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}
	
	public static ProfissionalSaude getPsSemLogin() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("926.946.320-68");
		ps.setNome("Ramon Teste");
		ps.setEmail(getValorAleatorio() + "ra@mon");
		ps.setIdProfissional(getValorAleatorio());
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}
	public static ProfissionalSaude getPsEmailInvalido() {
		ProfissionalSaude ps = new ProfissionalSaude();
		ps.setCpf("398.312.840-89");
		ps.setNome("Ramon Teste");
		ps.setEmail("raaaaamon");
		ps.setIdProfissional(getValorAleatorio());
		ps.setLogin(getValorAleatorio() + "login");
		ps.setEspecialidade("ACUPUNTURA - MED001");
		return ps;
	}
	
	public static String getValorAleatorio() {
		Random r = new Random();
		
		Integer i = r.nextInt(1000);
		
		return "ALEATORIO_" + i.toString();
	}
}
