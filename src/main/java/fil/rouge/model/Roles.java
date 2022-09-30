package fil.rouge.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privileges",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="privilieges_id", referencedColumnName = "id"))
    private List<Privileges> privileges;

    public Roles(){}

    public Roles(String name){
        this.name = name;
        this.privileges = new ArrayList<Privileges>();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Collection<Privileges> getPrivileges() {
        return privileges;
    }
    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;

        if(obj == null)
            return false;
        
        if(getClass() != obj.getClass())
            return false;

        Roles other = (Roles) obj;
        return Objects.equals(id, other.id);
    }
}
