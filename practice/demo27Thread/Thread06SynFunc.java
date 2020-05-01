package demo27Thread;

public class Thread06SynFunc {
    public static void main(String[] args) {
        RunnableImplSellTickets03SynFun syn = new RunnableImplSellTickets03SynFun();
        new Thread(syn).start();
        new Thread(syn).start();
        new Thread(syn).start();
        new Thread(syn).start();
    }
}