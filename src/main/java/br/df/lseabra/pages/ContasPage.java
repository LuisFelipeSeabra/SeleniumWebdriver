package br.df.lseabra.pages;

import org.openqa.selenium.By;

import br.df.lseabra.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	public void clicarSalvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
		
	}
	public String obterMsgSucesso() {
		String a = obterTexto(By.xpath("//div[@class='alert alert-success']"));
		return a;
	}
	
	public void clicarAlterar(String conta) {
		clicarBotao(By.xpath("//td[.='"+conta+"']/following-sibling::td/a"));
	}
	
	public String obterMsgErro() {
		String a = obterTexto(By.xpath("//div[@class='alert alert-danger']"));
		return a;
	}
	
	public void clicarExcluirConta(String conta) {
		clicarBotao(By.xpath("//td[.='"+conta+"']/following-sibling::td/a/following-sibling::a"));
	}
	
}
