package lin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/consumer")  //port:8080
@DefaultProperties(defaultFallback = "defaultFallback")  // for Hystrix
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private IUserFeignClient userFeignClient;

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "defaultFallback")
//    @HystrixCommand()  // for Hystrix
    public User queryById(@PathVariable("id") Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        String uri = instances.get(0).getUri().getHost();
//        int port = instances.get(0).getUri().getPort();
//        String url = "http://localhost:8081/user/" + id;
//        String url = "http://" + uri + ":" + port + "/user/" + id;
//        String serivceName = "user-service"; //想要调用的服务ID
//        String url = "http://" + serivceName + "/user/" + id;
        User user = userFeignClient.queryUserById(id);
        return user;
//        System.out.println(url);
//        return restTemplate.getForObject(url,User.class);
    }
    // for Hystrix
//    public User defaultFallback() {
    public User defaultFallback(@PathVariable("id") Long id) {
        User user = new User();
        user.setName("service busy...");
        return user;
    }
}
