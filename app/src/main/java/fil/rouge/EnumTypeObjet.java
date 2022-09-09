package fil.rouge;

import java.util.HashMap;
import java.util.Map;

public enum EnumTypeObjet {
    Outils(1), 
    Meubles(2), 
    Decoration(3), 
    ObjetRecoltable(4),
    Ressource(5);

    // A partir d'ici, c'est un model de syntaxe qui permet de modifier le comportement de l'énumération pour associer directement
    // une valeur au type d'objet, et pour y accéder il faut juste faire: EnumTypeObjet.Outils.getValue();
    
    private int value;
    private static Map<Integer, EnumTypeObjet> map = new HashMap<>();
    
    private EnumTypeObjet(int value) {
        this.value = value;
    }

    static {
        for (EnumTypeObjet objet_Type : EnumTypeObjet.values()) {
            map.put(objet_Type.value, objet_Type);
        }
    }

    public static EnumTypeObjet valueOf(int objet_Type) {
        return (EnumTypeObjet) map.get(objet_Type);
    }
    public int getValue() {
        return value;
    }
}
