package org.example.proxy;

/**
 * 對生產廠要求的接口
 */
public interface IProducer {
    /**
     * 方法: 銷售
     * @param money
     */
    void saleProduct(float money);

    /**
     * 方法: 售後
     * @param money
     */
    void afterService(float money);
}
