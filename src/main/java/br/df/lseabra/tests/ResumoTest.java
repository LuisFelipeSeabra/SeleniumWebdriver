package br.df.lseabra.tests;

import org.junit.Assert;
import org.junit.Test;

import br.df.lseabra.core.BaseTest;
import br.df.lseabra.pages.MenuPage;
import br.df.lseabra.pages.MovimentacaoPage;

public class ResumoTest extends BaseTest {
	MovimentacaoPage page = new MovimentacaoPage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void removerMovimentacao() {
		menu.acessarTelaResumoMensal();
		page.excluirMovimentacao("Movimentacao para exclusao");
		Assert.assertEquals("Movimentação removida com sucesso!", page.obterMsgSucesso());
	}
	
	
}
