import java.util.ArrayList;
import java.util.List;

public class Explorer extends LivingThing{
    private ArrayList<Treasure> treasures ;
    public Explorer(String description, int value, String c){
        super(description,value, c);
        treasures = new ArrayList<>();
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }


    public void addTreasure(Treasure t){
        treasures.add(t);
    }

//  this.treasures = treasures;

    public int getTreasureValue(){
        int i = 0;
        for (Treasure t :treasures) {
            i += t.getValue();
        }
        return i;
    }
}
