package demo28Waiting;

public class Pizza {
    private String type;
    private int num;

    public Pizza(String type, int num) {
        this.type = type;
        this.num = num;
    }

    public Pizza() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
