package br.df.lseabra.pages;

import org.openqa.selenium.By;

import br.df.lseabra.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldo(String conta){
		return obterTexto(By.xpath("//table[@id = 'tabelaSaldo']//tbody//td[contains(.,'"+ conta +"')]/following-sibling::td"));
		
	}
	
}
