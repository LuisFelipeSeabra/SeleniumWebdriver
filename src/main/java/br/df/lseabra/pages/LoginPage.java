package br.df.lseabra.pages;

import org.openqa.selenium.By;

import br.df.lseabra.core.BasePage;
import br.df.lseabra.core.DriverFactory;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");	
	}
	
	public void setEmail(String email) {
		escreve("email", email);
	}
	
	public void setSenha(String senha) {
		escreve("senha", senha);
	}
	
	public void clicarEmEntrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
		
	}
	
}
