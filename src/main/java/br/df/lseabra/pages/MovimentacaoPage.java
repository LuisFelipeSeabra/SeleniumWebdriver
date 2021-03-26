package br.df.lseabra.pages;

import org.openqa.selenium.By;


import br.df.lseabra.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public  void setTipoMovimentacao(String tipo) {
		selecionarCombo("tipo", tipo);
	}
	
	public  void setDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public  void setDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public  void setDescricao(String txt) {
		escreve("descricao", txt);
	}
	
	public  void setInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escreve("valor", valor);
	}
	
	public void selecionarConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setSituacaoPago() {
		clicarRadio("status_pago");
	}
	
	public void setSituacaoPendente() {
		clicarRadio("status_pendente");
	}
	
	public void salvarMovimentacao() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMsgSucesso() {
		String a = obterTexto(By.xpath("//div[@class='alert alert-success']"));
		return a;
	}
	
	public String obterMsgErro() {
		String a = obterTexto(By.xpath("//div[@class='alert alert-danger']"));
		return a;
	}
	
	public void excluirMovimentacao(String descricao) {
		clicarBotao(By.xpath("//table[@id='tabelaExtrato']//td[contains(.,'"+descricao +"')]//..//a"));		
	}
	public String obterMsgExclusaoMovimentacao() {
		String a = obterTexto(By.xpath("//div[@class='alert alert-success']"));
		return a;
	}
}
