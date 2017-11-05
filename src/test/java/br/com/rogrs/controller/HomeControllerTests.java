package br.com.rogrs.controller;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;


import br.com.rogrs.model.Endereco;
import br.com.rogrs.repository.EnderecoRepository;
import br.com.rogrs.service.ViaCEPService;
import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
@SpringBootTest
public class HomeControllerTests {

	private ModelMap map;
	@Autowired
	private HomeController ctrl;
	@Autowired
	private EnderecoRepository repository;
	@Autowired
	private ViaCEPService viaCEPService;
	
	private static final String CEP = "20541170";

	@Before
	public void setUp() throws Exception {
		map = new ModelMap();
		repository = mock(EnderecoRepository.class);
		viaCEPService = mock(ViaCEPService.class);
		ctrl = new HomeController(repository, viaCEPService);
	}

    public class Home {

        @Test
        public void shouldAddInsertRecordToModelMap() throws Exception {
            ctrl.home(map);

            assertThat(map, hasKey("insertRecord"));
            assertTrue(map.get("insertRecord") instanceof Endereco);

            Endereco insertRecord = (Endereco) map.get("insertRecord");
            assertNull(insertRecord.getCep());
        }

        @Test
        public void shouldQueryRepositoryForAllRecords() throws Exception {
            ctrl.home(map);

            verify(repository, only()).findAll();
        }

        @Test
        public void shouldAddRecordsFromRepositoryToModelMap() throws Exception {
            when(repository.findAll()).thenReturn(Arrays.asList(new Endereco(CEP), new Endereco(CEP), new Endereco(CEP)));

            ctrl.home(map);

            assertThat(map, hasKey("records"));
            assertTrue(map.get("records") instanceof List);

            List<Endereco> records = getRecords();
            assertThat(records, hasSize(3));
        }

        @SuppressWarnings("unchecked")
        private List<Endereco> getRecords() {
            return (List<Endereco>) map.get("records");
        }
    }

    public class InsertData {

        private MapBindingResult bindingResult;

        @Before
        public void setUp() throws Exception {
            bindingResult = new MapBindingResult(new HashMap<>(), "insertRecord");
        }

       /* @Test
        public void shouldSaveRecordWhenThereAreNoErrors() throws Exception {
        	Endereco record = new Endereco(CEP);
            insertData(record);

            verify(repository, times(1)).save(record);
        }*/

        @Test
        public void shouldNotSaveRecordWhenThereAreErrors() throws Exception {
            bindingResult.addError(new ObjectError("", ""));

            insertData(new Endereco(CEP));

            verify(repository, never()).save(any(Endereco.class));
        }

       /* @Test
        public void shouldAddNewInsertRecordToModelMap() throws Exception {
            Endereco record = new Endereco(CEP);
            insertData(record);

            assertThat(map, hasKey("insertRecord"));
            assertThat(map.get("insertRecord"), is(not(record)));
        }

        @Test
        public void shouldAddRecordsToModelMap() throws Exception {
            insertData(new Endereco(CEP));

            assertThat(map, hasKey("records"));
        }*/

        private void insertData(Endereco record) {
            ctrl.insertData(map, record, bindingResult);
        }
    }
}
