package cn.itcast.order.service;


import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import ct.itcast.feigh.clients.UserClient;
import ct.itcast.feigh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }

//    @Autowired
//    private  RestTemplate restTemplate;
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        String url="http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }

}
