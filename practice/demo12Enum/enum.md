# ENUM
- define a enum class
```java
    public enum Color {
        // 枚举的成员相当于枚举的对象,外部只能访问,不能添加和修改
        RED, GREEN, BLUE;
    }
```
- use a enum class
```java
    public void test2 () {
        colorEnum = Color.RED;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());
        System.out.println(colorEnum.toString());
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
        }
```
- define constructor inside enum class
枚举类可以定义构造方法,但是只能供枚举内部成员访问
构造方法用来给枚举成员赋值,由枚举成员调用