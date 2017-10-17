package br.com.rogrs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.rogrs.model.Endereco;

@Service
public class ViaCEPService {
	
	private static final Logger logger = LoggerFactory.getLogger(ViaCEPService.class);

	@Value("${url.service.viacep}")
	private String url;

	public Endereco buscaCEP(final String cep) {
		Endereco endereco = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			endereco = restTemplate.getForObject(String.format(url, cep), Endereco.class);

		} catch (HttpClientErrorException ex) {
			logger.error(String.format("StatusCode [%s] -Message [%s]",ex.getStatusCode(),ex.getMessage()),ex);
			
		}
		return endereco;

	}

}