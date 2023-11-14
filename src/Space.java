public class Space {


    private LivingThing occupant;

    private Treasure cache;

    public Space() {
        occupant = null;
        setCache(null);
    }


    public Space(Treasure t) {
        cache = t;
    }

    public LivingThing getOccupant() {
        return occupant;
    }

    public Space(LivingThing l) {
        this.occupant = l;
        cache = null;
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

    public String getConsoleStr(boolean reveal) {
        if (reveal) {
            if (this.occupant != null) {
                return this.occupant.getConsoleStr();
            }else if(this.cache != null) {
                return this.cache.getConsoleStr();
            } else {
                return "-";
            }
        } else{
            if (this.occupant instanceof Explorer){
                return this.occupant.getConsoleStr();
            }else{
                return "-";
            }
        }
    }


    public Treasure getCache() {
        return cache;
    }

    public void setCache(Treasure cache) {
        this.cache = cache;
    }
}
