package org.example.cglib;

import org.example.proxy.IProducer;

/**
 * 一個生產者
 */
public class Producer {

    /**
     * 方法: 銷售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("銷售產品，並拿到錢: " + money);
    }

    /**
     * 方法: 售後
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售後服務，並拿到錢: " + money);
    }

}
