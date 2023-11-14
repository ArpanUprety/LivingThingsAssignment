import java.util.ArrayList;

public class Monster extends LivingThing{
    private int damage;
    public int getDamage() {
        return damage;
    }
    public Monster(String description, int value, String c, int d){
        super(description,value,c);
        this.damage = d;
    }

    public  void Hurt(LivingThing l){
        l.setHealth(l.getHealth() - damage);
    }

}
