package br.com.rogrs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WSCEPService {
	
	 private static final Logger log = LoggerFactory.getLogger(WSCEPService.class);
	
	private String url = "https://viacep.com.br/ws/#cep/piped/";
	

	
	public  String  findCEP(final String cep){
		
		RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject(url.replace("#cep", cep), String.class);
        log.info(quote.toString());
        return quote;
		
	}

}