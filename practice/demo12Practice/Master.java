
import java.util.ArrayList;

public class Master extends User {
    public Master() {
    }

    public Master(String userName, int balance) {
        super(userName, balance);
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        int eachMoney = totalMoney / count;
        int mod = totalMoney % count;
        ArrayList<Integer> sendList = new ArrayList<>();
        int curBalance = super.getBalance();
        if (curBalance > (totalMoney - mod)) {
            // if mod > 1, then the left money will give back to master.
            curBalance -= (totalMoney - mod);
        }else{
            System.out.println("failed: left money is not enough");
            return sendList;
        }
        super.setBalance(curBalance);
        // System.out.println("left money: " + curBalance);
        System.out.println("left money: " + getBalance());
        for (int i = 0; i < count; i++){
            sendList.add(eachMoney);
        }
        return sendList;
    }
}

