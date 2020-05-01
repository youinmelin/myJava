package demo27Thread;

public class Thread05Synchornized {
    public static void main(String[] args) {
        RunnableImplSellTickets02 syn = new RunnableImplSellTickets02();
        Thread t = new Thread(syn);
        t.start();
        new Thread(syn).start();
        new Thread(syn).start();
        new Thread(syn).start();
    }
}