package demo01;

public enum Color implements ColorApi{
    // 通过全参或者无参构造方法为枚举的成员赋值
    RED("red", 0), GREEN("green", 1), BLUE("blue", 2), YELLOW;

    private int colorValue ;
    private String colorStr ;

    // 无参构造方法
    Color() {
    }
    // 全参构造方法
    private Color (String colorStr, int colorValue) {
        this.colorValue = colorValue;
        this.colorStr = colorStr;
    }

    // 枚举重写接口的方法
    @Override
    public String colorStr() {
        return colorStr;
    }

    @Override
    public int colorValue() {
        return colorValue;
    }


}
