package br.df.lseabra.core;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.df.lseabra.pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule 
	public TestName testName = new TestName();
	
	@Before
	public void Login() {
		page.acessarTelaInicial();
		page.setEmail("felipeseabra2405@gmail.com");
		page.setSenha("felipe");
		page.clicarEmEntrar();
	}
	
	@After
	public void shutDown() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo =  ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+ File.separator +"screenshot/"
				+ File.separator + testName.getMethodName()+ ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
				DriverFactory.killDriver();
		}
	
	}
}
