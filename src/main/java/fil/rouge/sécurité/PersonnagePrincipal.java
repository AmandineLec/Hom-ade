package fil.rouge.sécurité;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fil.rouge.model.Personnage;
import fil.rouge.model.Roles;

public class PersonnagePrincipal implements UserDetails {

    private Personnage personnage;

    public PersonnagePrincipal(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
        //return stream(this.personnage.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        //return this.transformRoleAsStrings(this.personnage.getRoles());
    }


    private Stream<GrantedAuthority> transformRoleAsStrings(Roles role){
        int size = role.getPrivileges().size()+1;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(size);

        authorities.add(new SimpleGrantedAuthority(role.getName()));

        List<? extends GrantedAuthority> privileges = role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).toList();

        authorities.addAll(privileges);

        return authorities.stream();
    }

    private Object stream(Collection<Roles> roles) {
        return null;
    }

    @Override
    public String getPassword() {
        return this.personnage.getPassword();
    }

    @Override
    public String getUsername() {
        return this.personnage.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
