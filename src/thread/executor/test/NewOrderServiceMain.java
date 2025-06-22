package thread.executor.test;

public class NewOrderServiceMain {

    public static void main(String[] args) throws InterruptedException {
        String orderNo = "Order#1234";
        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order(orderNo);
    }
}
