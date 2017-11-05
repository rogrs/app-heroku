package br.com.rogrs.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogrs.model.Endereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViaCEPServiceTests {

	@Autowired
	private ViaCEPService wsCEPService;
	
	
	private static final Endereco CEP_SUCESSO = new Endereco("20541170");
	private static final Endereco CEP_ERRO = new Endereco("1111111");

	@Test
	public void testeBuscaCEP() throws Exception {

		Endereco result = wsCEPService.buscaCEP(CEP_SUCESSO);;
		assertNotNull(result);
		assertNotNull(result.getCep());
		assertNotNull(result.getBairro());
		assertNotNull(result.toString());

	}
	

	@Test
	public void testeBuscaCEPError() throws Exception {

		Endereco result =  wsCEPService.buscaCEP(CEP_ERRO);
		assertNotNull(result);

	}
	

}
