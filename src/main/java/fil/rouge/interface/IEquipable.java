package fil.rouge;

import fil.rouge.model.Personnage;

public interface IEquipable {
    public boolean equiper(Personnage target);
    public boolean desequipper(Personnage target);
}
