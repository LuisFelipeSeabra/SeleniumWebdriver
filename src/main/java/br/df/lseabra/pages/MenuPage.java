package br.df.lseabra.pages;

import br.df.lseabra.core.BasePage;

public class MenuPage extends BasePage {

	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");	
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");	
	}
	
	public void acessarTelaCriarMovimentacao() {
		clicarLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink("Resumo Mensal");
	}	
	
	public void acessarTelaHome() {
		clicarLink("Home");
	}	
}
