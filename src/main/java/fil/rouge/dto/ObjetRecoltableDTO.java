package fil.rouge.dto;

public class ObjetRecoltableDTO {
    private int idObjetRecoltable;
    private String nom;
    private int pv;
    private long cooldown;
    private long disparitionTime;


    //#region getset
    public int getIdObjetRecoltable() {
        return idObjetRecoltable;
    }
    public void setIdObjetRecoltable(int idObjetRecoltable) {
        this.idObjetRecoltable = idObjetRecoltable;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
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
        return "ObjetRecoltableDTO [cooldown=" + cooldown + ", disparitionTime=" + disparitionTime
                + ", idObjetRecoltable=" + idObjetRecoltable + ", nom=" + nom + ", pv=" + pv + "]";
    }


    public ObjetRecoltableDTO(int idObjetRecoltable, String nom, int pv, long cooldown, long disparitionTime) {
        this.idObjetRecoltable = idObjetRecoltable;
        this.nom = nom;
        this.pv = pv;
        this.cooldown = cooldown;
        this.disparitionTime = disparitionTime;
    }
    
    public ObjetRecoltableDTO() {}
}
