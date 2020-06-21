package lin.domain;

import java.io.Serializable;

public class Account implements Serializable{
    private Integer id;
    private String name;
    private Double money;

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Account() {
    }
}
