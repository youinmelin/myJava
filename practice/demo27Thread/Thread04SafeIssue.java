package demo27Thread;

public class Thread04SafeIssue {
    public static void main(String[] args) {
        RunnableImplSellTickets sell = new RunnableImplSellTickets();
        Thread th = new Thread(sell);
        th.start();
        new Thread(sell).start();
        new Thread(sell).start();
    }
}