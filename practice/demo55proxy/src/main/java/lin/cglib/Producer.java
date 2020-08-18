package lin.cglib;

import lin.proxy.IProducer;

/*
a producer
 */
public class Producer {

    public void saleProduct(float money) {
        System.out.println("get money "+ money +"yuan, and sale product.");
    }

    public void afterService(float money) {
        System.out.println("provide after service, and get money:" + money);
    }
}
