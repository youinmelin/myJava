package demo27Thread;

public class Thread07Lock {
    public static void main(String[] args) {
        RunnableImplSellTickets04Lock sell = new RunnableImplSellTickets04Lock();
        new Thread(sell).start();
        new Thread(sell).start();
        new Thread(sell).start();
        new Thread(sell).start();
        new Thread(sell).start();
        
    }

}