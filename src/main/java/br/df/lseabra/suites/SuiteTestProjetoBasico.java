package br.df.lseabra.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.df.lseabra.core.DriverFactory;
import br.df.lseabra.tests.ContaTest;
import br.df.lseabra.tests.CriarMassa;
import br.df.lseabra.tests.HomeTest;
import br.df.lseabra.tests.MovimentacaoTest;




	@RunWith(Suite.class)
	@SuiteClasses({
		CriarMassa.class,
		ContaTest.class,
		HomeTest.class,
		MovimentacaoTest.class
	})
	public class SuiteTestProjetoBasico {
		@AfterClass
		public static void finalizaTudo() {
			DriverFactory.killDriver();
		}

	}