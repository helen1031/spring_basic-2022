package spring_basic.spring_basic2022.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);


}
