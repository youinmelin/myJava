
public class User {
    private String userName ;
    private int balance;

    public User() {
    }

    public User(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
    }
    
    public void show(){
        System.out.println(userName + "have money: " + balance);
    }

    public String getUserName(){
        return userName;
    }

    public int getBalance(){
        return balance;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}


        

