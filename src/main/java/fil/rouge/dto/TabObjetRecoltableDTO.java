package fil.rouge.dto;

import java.util.Arrays;


public class TabObjetRecoltableDTO {
    private final int tailleTab = 35;

    private ObjetRecoltableDTO[] objetsRecoltables = new ObjetRecoltableDTO[tailleTab];

    //#region getset
    public ObjetRecoltableDTO getObjetsRecoltables(int index) {
        return objetsRecoltables[index];
    }

    public void addObjetsRecoltables(ObjetRecoltableDTO objetRecoltableDto, int index) {
        this.objetsRecoltables[index] = objetRecoltableDto;
    }

    public ObjetRecoltableDTO[] getObjetsRecoltables() {
        return objetsRecoltables;
    }

    //#endregion

    public TabObjetRecoltableDTO() {
        
    }

    @Override
    public String toString() {
        return "TabObjetRecoltableDTO [objetsRecoltables=" + Arrays.toString(objetsRecoltables) + "]";
    }

    
    
}
