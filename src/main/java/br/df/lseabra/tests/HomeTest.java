package br.df.lseabra.tests;

import org.junit.Assert;
import org.junit.Test;

import br.df.lseabra.core.BaseTest;
import br.df.lseabra.pages.HomePage;
import br.df.lseabra.pages.MenuPage;

public class HomeTest extends BaseTest {

	MenuPage menu = new MenuPage();
	HomePage page = new HomePage();
	
	@Test
	public void validarSaldo() {
		menu.acessarTelaHome();
		
		Assert.assertEquals("534.00", page.obterSaldo("Conta para saldo"));
	}
			
}
