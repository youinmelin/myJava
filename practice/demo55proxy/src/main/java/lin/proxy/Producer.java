package lin.proxy;

/*
a producer
 */
public class Producer implements IProducer {

    public void saleProduct(float money) {
        System.out.println("get money "+ money +"yuan, and sale product.");
    }

    public void afterService(float money) {
        System.out.println("provide after service, and get money:" + money);
    }
}
