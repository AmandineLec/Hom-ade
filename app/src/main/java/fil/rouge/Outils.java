package fil.rouge;

public abstract class Outils extends Objet implements Equipable {

        //#region Variables
        protected int resistance;
        protected int capacite;
         //#endregion
        
        //#region Constructeur
        public Outils(String nom) {
            super(nom);
        }

        public Outils(int id){
            super(id);
        }
        //#endregion

        //#region GETTER & SETTER
        public int getResistance() {
            return resistance;
        }

        public void setResistance(int resistance) {
            this.resistance = resistance;
        }
        public int getCapacite() {
            return capacite;
        }
        public void setCapacite(int capacite) {
            this.capacite = capacite;
        }
        
        //#endregion
        

        //#region METHOD

        public void equiper(Joueur target){

        }
        public void desequipper(Joueur target){
            
        }
        //#endregion       
    
}
