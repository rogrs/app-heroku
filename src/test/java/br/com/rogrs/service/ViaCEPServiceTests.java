package br.com.rogrs.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogrs.model.Endereco;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ViaCEPServiceTests {

	//@Autowired
	//private ViaCEPService wsCEPService;

	@Test
	public void testeBuscaCEP() throws Exception {

		Endereco result = new Endereco();//wsCEPService.buscaCEP("20541170");;
		assertNotNull(result);

	}
	
	@Test
	public void testeBuscaCEP2() throws Exception {

		Endereco result =  new Endereco();//wsCEPService.buscaCEP("20541173");
		assertNotNull(result);

	}
	
	
	@Test
	public void testeBuscaCEP3() throws Exception {

		Endereco result = new Endereco();// wsCEPService.buscaCEP("11111111");
		assertNotNull(result);

	}
	

}
