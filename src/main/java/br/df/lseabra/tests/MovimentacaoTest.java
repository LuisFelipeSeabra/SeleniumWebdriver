package br.df.lseabra.tests;

import org.junit.Assert;
import org.junit.Test;

import br.df.lseabra.core.BaseTest;
import br.df.lseabra.pages.MenuPage;
import br.df.lseabra.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	MovimentacaoPage page = new MovimentacaoPage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testInserirMovimentacao() {
		menu.acessarTelaCriarMovimentacao();
		page.setTipoMovimentacao("Receita");
		page.setDataMovimentacao("07/07/1990");
		page.setDataPagamento("25/03/2021");
		page.setDescricao("teste");
		page.setInteressado("Luis Felipe");
		page.setValor("85");
		page.selecionarConta("conta do teste");
		page.setSituacaoPago();	
		page.salvarMovimentacao();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMsgSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menu.acessarTelaCriarMovimentacao();
		page.salvarMovimentacao();
		
		Assert.assertEquals("Data da Movimentação é obrigatório\n"
				+ "Data do pagamento é obrigatório\n"
				+ "Descrição é obrigatório\n"
				+ "Interessado é obrigatório\n"
				+ "Valor é obrigatório\n"
				+ "Valor deve ser um número", page.obterMsgErro());	
	}

	@Test
	public void testInserirMovimentacaoFutura() {
		menu.acessarTelaCriarMovimentacao();
		page.setTipoMovimentacao("Receita");
		page.setDataMovimentacao("07/07/2022");
		page.setDataPagamento("25/03/2021");
		page.setDescricao("teste");
		page.setInteressado("Luis Felipe");
		page.setValor("85");
		page.selecionarConta("conta do teste");
		page.setSituacaoPago();	
		page.salvarMovimentacao();
		
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", page.obterMsgErro());
	}
	@Test
	public void removerMovimentacao() {
		menu.acessarTelaResumoMensal();
		page.excluirMovimentacao("Movimentacao para exclusao");
		
		Assert.assertEquals("Movimentação removida com sucesso!", page.obterMsgExclusaoMovimentacao());
	}
}
