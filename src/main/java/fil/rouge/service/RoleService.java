package fil.rouge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.RoleRepository;
import fil.rouge.model.Roles;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository rRepository;

    public void createRoleIfNotExists(String roleName){
        Optional<Roles> optRole = rRepository.findByName(roleName);

        if (optRole.isEmpty())
            rRepository.save(new Roles(roleName));
    }

    // private boolean createRoleIfNotExists(String roleName){;
    //     List<Roles> roles = new ArrayList<Roles>();
    //     for (Roles r : roles){
    //         if(r.getName().equals(roleName)){
    //             return false;
    //         }
    //     }
    //     Roles newRole = new Roles(roleName);
    //     rRepository.save(newRole);
    //     return true;
    //}
}
