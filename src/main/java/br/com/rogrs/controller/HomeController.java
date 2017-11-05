
package br.com.rogrs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rogrs.model.Endereco;
import br.com.rogrs.repository.EnderecoRepository;
import br.com.rogrs.service.ViaCEPService;

@Controller
@RequestMapping("/")
public class HomeController {

	private EnderecoRepository repository;

	@Autowired
	private ViaCEPService viaCEPService;

	@Autowired
	public HomeController(EnderecoRepository repository, ViaCEPService viaCEPService) {
		this.repository = repository;
		this.viaCEPService = viaCEPService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		List<Endereco> enderecos = repository.findAll();
		model.addAttribute("records", enderecos);
		model.addAttribute("insertRecord", new Endereco());
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String insertData(ModelMap model, @ModelAttribute("insertRecord") @Valid Endereco record,
			BindingResult result) {
		if (!result.hasErrors()) {

			Endereco endereco = viaCEPService.buscaCEP(record);

			if (null == endereco || endereco.isErro()) {
				throw new ResourceNotFoundException(String.format("O cep %s não existe!", record.getCep()));
			}

			repository.save(endereco);
		}
		return home(model);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -6252766749487342137L;

		public ResourceNotFoundException(String message) {
			super(message);
		}
	}
}
