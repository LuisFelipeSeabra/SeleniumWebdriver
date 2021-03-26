package br.df.lseabra.tests;

import org.junit.Assert;
import org.junit.Test;


import br.df.lseabra.core.BaseTest;
import br.df.lseabra.pages.ContasPage;
import br.df.lseabra.pages.MenuPage;


public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("conta do teste");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMsgSucesso());
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterar("Conta para alterar");
		contasPage.setNome("conta do teste alterada");
		contasPage.clicarSalvar();
	
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMsgSucesso());
	}

	@Test
	public void testInserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.clicarSalvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMsgErro());
	}
	@Test
	public void removerConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMsgErro());
	}
	
	
	
}
