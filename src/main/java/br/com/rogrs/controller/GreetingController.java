package br.com.rogrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rogrs.service.WSCEPService;

@Controller
public class GreetingController {
	
	@Autowired
	private WSCEPService wsCEPService;

    @RequestMapping("/findCEP")
    public ResponseEntity<String> greeting(@RequestParam(value="cep") String cep) {
        
        String string =  wsCEPService.findCEP(cep);
        return new ResponseEntity<>(string, HttpStatus.OK);
    }

}