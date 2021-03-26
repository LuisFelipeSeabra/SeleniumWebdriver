package br.df.lseabra.tests;

import org.junit.Test;

import br.df.lseabra.core.BaseTest;
import br.df.lseabra.pages.CriarMassaPage;
import br.df.lseabra.pages.MenuPage;

public class CriarMassa extends BaseTest {
	
	CriarMassaPage page = new CriarMassaPage();
	MenuPage menu = new MenuPage();
	@Test
	public void clicarEmCriarMassa() {
		menu.acessarTelaHome();
		page.criarMassa();
		
	}

}
