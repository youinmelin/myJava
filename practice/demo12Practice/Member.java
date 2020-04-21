import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member () {
    }

    public Member (String userName, int balance) {
        super(userName, balance);
    }

    public void receive(ArrayList<Integer> redList) {
        if (redList != null) {
            int redIndex = new Random().nextInt(redList.size());
            int getMoney = redList.remove(redIndex);
            int leftMoney = super.getBalance();
            leftMoney += getMoney;
            super.setBalance(leftMoney);
            System.out.println("I'm " + super.getUserName() + ". I got " + redList.get(redIndex) + "$. I left " + leftMoney + "$ now.");
        }else{
            int leftMoney = super.getBalance();
            System.out.println("I'm " + super.getUserName() + ". I didn't get red package. I left " + leftMoney + "$ now.");
        }
    }
}

