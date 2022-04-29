package cn.itcast.order.service;



import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.itcast.clients.UserClient;
import com.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.
        //使用restTemplate发送http请求
        //String url = "http://localhost:8082/user/" + order.getUserId();
        //String url = "http://userservice/user/" + order.getUserId();
        //User user = restTemplate.getForObject(url, User.class);

        //使用feign发送http请求
        User user = userClient.getUSerById(orderId);
        // 3.
        order.setUser(user);
        // 4.返回
        return order;
    }
}
