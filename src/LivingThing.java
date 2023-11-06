import java.util.Locale;

public class LivingThing {

    private String name;
    private int health;
    private String pieceColor = ConsoleColors.RESET;

    public LivingThing(String n, int h){
        this.setName(n);
        this.setHealth(h);
         this.setPieceColor(ConsoleColors.YELLOW);
    }

    public LivingThing(String n, int h, String p){
        this.setName(n);
        this.setHealth(h);
          this.setPieceColor(p);

    }

    public void setName(String name) {

        if (name.trim() == ""){
            this.name = "undefined";

        }else {
            this.name = name;
        }
    }

    public void setHealth(int health) {
        if (health < 0){
            this.health = 0;
        } else {
            this.health = health;
        }

    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getConsoleStr( ){
    String c = pieceColor+ name.charAt(0) + ConsoleColors.RESET ;
    return c;
    }
}
