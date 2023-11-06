public class Space {


private LivingThing occupant;

public Space(){
    occupant = null;
}
    public LivingThing getOccupant() {
        return occupant;
    }
    public Space(LivingThing l){
       this.occupant = l;
    }

    public void setOccupant(LivingThing occupant) {
        this.occupant = occupant;
    }

    public String getConsoleStr() {
        String n;
        if (occupant == null) {
            return "-";
        } else {
           return occupant.getConsoleStr();
        }

    }



}
