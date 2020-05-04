package demo28Waiting;

public class Maker implements Runnable {
    private Pizza obj;
    
    @Override
    public void run() {
        int count ;
        while (true) {
            synchronized (obj) {
                count = obj.getNum();
                if (count > 3) {
                    try {
                        this.obj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("Maker: Making pizza......");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                count = obj.getNum();
                count++;
                obj.setNum(count);
                System.out.println("Maker: Now there are "+ count +" pizza.");
                this.obj.notify();
            }
        }
    }

    public Maker(Pizza obj) {
        this.obj = obj;
    }
}