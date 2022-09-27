package fil.rouge.dto;


public class InscriptionDto {


  protected String name;

  protected int sexe = 1;

  protected String mail;

  protected String password;

  public InscriptionDto(String name, int sexe) {
      this.name = name;
      this.sexe = sexe;
    }
  
  public InscriptionDto(String name, int sexe, String mail, String password) {
      this.name = name;
      this.sexe = sexe;
      this.mail = mail;
      this.password = password;
    }
  
  public InscriptionDto(){}
    
  // #region GET/SET

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public int getSexe() {
    return sexe;
  }

  public void setSexe(int newSexe) {
    this.sexe = newSexe;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  //#endregion
}
