package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "element_recoltable")
public class ObjetRecoltable {
    @Id
    @Column(name = "id_element_recoltable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idElementRecoltable;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected Integer categorie;

    @Column(name = "pv")
    protected int pv;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "objet_element_recoltable",
        joinColumns = @JoinColumn(name = "id_element_recoltable"),
        inverseJoinColumns = @JoinColumn(name = "id_objet")
    )
    @JsonBackReference
    protected Set<Outil> outils = new HashSet<Outil>(); // id de l'outil à utiliser pour récolter

    @OneToMany(mappedBy = "objetRecoltable")
    @JsonBackReference
    protected Set<RessourcesRecoltees> ressourcesRecoltees = new HashSet<RessourcesRecoltees>();
    
    @Column(name = "niveau_requis")
    protected int niveauRequis;
    
    @Column(name = "cooldown")
    protected long cooldown;
    
    @Transient
    protected long disparitionTime;
    
    //#region Constructeurs

    public ObjetRecoltable() {}

    public ObjetRecoltable(String nom){
        this.nom = nom;
    }

    public ObjetRecoltable(String nom, int categorie, int niveauRequis, int pv){
        this.nom = nom;
        this.categorie = categorie;
        this.niveauRequis = niveauRequis;
        this.pv = pv;
    }
    //#endregion


    //#region GETSET

    public int getIdElementRecoltable() {
        return idElementRecoltable;
    }

    public void setIdElementRecoltable(int idElementRecoltable) {
        this.idElementRecoltable = idElementRecoltable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public Set<Outil> getOutils() {
        return outils;
    }

    public void addOutil(Outil outil) {
        outils.add(outil);
    }

    public Set<RessourcesRecoltees> getRessourcesRecoltees() {
        return ressourcesRecoltees;
    }

    public void addRessourcesRecoltees(RessourcesRecoltees ressourcesRecoltees) {
        this.ressourcesRecoltees.add(ressourcesRecoltees);
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
    
    public long getCooldown() {
        return cooldown;
    }

    public void setCooldown(long cooldown) {
        this.cooldown = cooldown;
    }

    public long getDisparitionTime() {
        return disparitionTime;
    }

    public void setDisparitionTime(long disparitionTime) {
        this.disparitionTime = disparitionTime;
    }


    //#endregion

    @Override
    public String toString() {
        return "ObjetRecoltable [categorie=" + categorie + ", cooldown=" + cooldown + ", disparitionTime="
                + disparitionTime + ", idElementRecoltable=" + idElementRecoltable + ", niveauRequis=" + niveauRequis
                + ", nom=" + nom + ", outils=" + outils + ", pv=" + pv + ", ressourcesRecoltees=" + ressourcesRecoltees
                + "]";
    }

    
}
