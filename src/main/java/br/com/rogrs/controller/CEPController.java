package br.com.rogrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogrs.model.Endereco;
import br.com.rogrs.service.ViaCEPService;

@RestController
@RequestMapping("/buscar")
public class CEPController {
	
	@Autowired
	private ViaCEPService viaCEPService;

    @RequestMapping("/cep")
    public ResponseEntity<Endereco> buscarCEP(@RequestParam(value="cep") String cep) {
        
    	Endereco endereco =  viaCEPService.buscaCEP(cep);
    	
    	if (null == endereco || endereco.isErro()) {
            throw new ResourceNotFoundException("CEP não encontrado!");
        }
    	
    	
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException
    {       
        private static final long serialVersionUID = -6252766749487342137L;    
        public ResourceNotFoundException(String message) {
            super(message);
        }    
    }

}