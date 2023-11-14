public class Treasure {
    private int value;
    private String description;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Treasure(String s , int v){
        setDescription(s);
        setValue(v);

    }

    public Treasure(){
        setDescription("gold");
        setValue(5);

    }
    public String getConsoleStr( ){
        String c = ConsoleColors.YELLOW + description.charAt(0) + ConsoleColors.RESET ;
        return c;
    }
}
