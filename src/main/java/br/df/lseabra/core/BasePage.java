package br.df.lseabra.core;

import static br.df.lseabra.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void escreve(String id_campo, String texto ) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id( id_campo)).getAttribute("value");
	}
	
	public void clicarRadio(String id_campo) {
		getDriver().findElement(By.id( id_campo)).click();
	}
	
	public boolean isRadioMarcado(String id_campo) {
		return getDriver().findElement(By.id( id_campo)).isSelected();
	}	
	
	public void selecionarCombo(String id_campo, String valor) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String obterValorCombo(String id_campo) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarBotao(String id_campo) {
		clicarBotao(By.id( id_campo));
	}
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public void clicarXpath(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
		
		}
	public String obterTextoDeAlerta() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public void aceitarAlerta() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();	
	}

	public Integer retornaQtdCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	public Boolean verificaSeElementoPertenceCombo(String id, String op) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals(op)) {
				encontrou = true;
			}
		}
		return encontrou;
		
	}
	public Integer SelecionarEVerificarQtdElementosSelecionados(String id, List<String> lista) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		int i = 0;
		for (i=0;i<lista.size();i++) {
			combo.selectByVisibleText(lista.get(i));
		}
		List<WebElement> options = combo.getAllSelectedOptions();
		return options.size();			
	}
	public Integer desselecionarEVerificarQtdElementosSelecionados(String id, List<String> lista) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		int i = 0;
		for (i=0;i<lista.size();i++) {
			combo.deselectByVisibleText(lista.get(i));			
		}
		List<WebElement> options = combo.getAllSelectedOptions();
		return options.size();			
	}	
	

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
