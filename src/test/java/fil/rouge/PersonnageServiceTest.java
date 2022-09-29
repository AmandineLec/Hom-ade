package fil.rouge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.service.PersonnageService;

public class PersonnageServiceTest {
    @MockBean
	PersonnageRepository personnageRepository;

    @Autowired
	PersonnageService personnageService;
    
}
