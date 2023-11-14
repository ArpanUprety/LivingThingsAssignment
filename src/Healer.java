import java.util.ArrayList;

public class Healer extends LivingThing{
    private int healValue;

    public int getHealValue() {
        return healValue;
    }

    public Healer(String description, int value, String c, int h){
        super(description,value,c);
        this.healValue = h;
        ArrayList<Treasure> healed = new ArrayList<>();
    }

    public void Heal(LivingThing l){
        l.setHealth(l.getHealth() + getHealValue());
    }

}
