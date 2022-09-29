package fil.rouge.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PersonnageDto {

  @NotNull
  @NotEmpty
  protected String name;

  @NotNull
  @NotEmpty
  protected int sexe;

  @NotNull
  @NotEmpty
  protected String mail;

  @NotNull
  @NotEmpty
  protected String password;

  public PersonnageDto(String name, int sexe) {
      this.name = name;
      this.sexe = sexe;
    }

  public PersonnageDto(String mail, String password){
    this.mail = mail;
    this.password = password;
  }
  
  public PersonnageDto(String name, int sexe, String mail, String password) {
      this.name = name;
      this.sexe = sexe;
      this.mail = mail;
      this.password = password;
    }
  
  public PersonnageDto(){}
    
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
