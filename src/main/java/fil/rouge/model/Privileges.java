package fil.rouge.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Privileges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String name;

    public Privileges(){}
    public Privileges(String name){
        this.name = name;
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
    
    @Override
    public int hashCode(){
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;

        if(obj == null)
            return false;
        
        if(getClass() != obj.getClass())
            return false;

        Privileges other = (Privileges) obj;
        return Objects.equals(id, other.id);
    }
}
