package thread.executor.test;

public class OldOrderServiceMain {

    public static void main(String[] args) throws InterruptedException {
        String orderNo = "Order#1234";
        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);
    }
}
