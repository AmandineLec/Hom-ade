package fil.rouge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.model.Personnage;



@Service
public class RecolteService {

    @Autowired
    RamassageService ramassageService;

    @Autowired
    RecoltageService recoltageService;
    
    public boolean recoltageRamassage(Personnage personnage, int objRecoltableId) {

        

        return true;
    }
}
