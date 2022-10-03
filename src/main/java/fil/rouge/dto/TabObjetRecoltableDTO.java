package fil.rouge.dto;

public class TabObjetRecoltableDTO {
    private final int tailleTab = 10;

    private ObjetRecoltableDTO[] ObjetsRecoltables;

    //#region getset
    public ObjetRecoltableDTO[] getObjetsRecoltables() {
        return ObjetsRecoltables;
    }

    public void setObjetsRecoltables(ObjetRecoltableDTO[] ObjetsRecoltables) {
        this.ObjetsRecoltables = ObjetsRecoltables;
    }

    //#endregion

    public TabObjetRecoltableDTO() {
        this.ObjetsRecoltables = new ObjetRecoltableDTO[tailleTab];
    }
    
}
