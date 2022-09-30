package fil.rouge.sécurité;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Personnage;
import fil.rouge.model.Roles;

@Service("userDetailsService")
public class PersonnageDetailsService implements UserDetailsService {

    @Autowired
    private PersonnageRepository pRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Personnage> perso = pRepository.findByMail(mail);
        if(perso.isEmpty())
            throw new UsernameNotFoundException("Ce mail n'existe pas");

        Personnage personnage = perso.get();

        List<GrantedAuthority> authorities = personnage.getRoles().stream().flatMap(this::transformRoleAsStrings).toList();

        return new org.springframework.security.core.userdetails.User(personnage.getMail(), personnage.getPassword(), personnage.isEnabled(), true, true, true, authorities);
    }

    private Stream<GrantedAuthority> transformRoleAsStrings(Roles role){
        int size = role.getPrivileges().size()+1;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(size);

        authorities.add(new SimpleGrantedAuthority(role.getName()));

        List<? extends GrantedAuthority> privileges = role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).toList();

        authorities.addAll(privileges);

        return authorities.stream();
    }
}
