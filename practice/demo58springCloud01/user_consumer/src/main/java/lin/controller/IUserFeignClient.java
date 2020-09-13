package lin.controller;

import lin.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface IUserFeignClient {
    @GetMapping("/user/{id}")
    public User queryUserById(@PathVariable("id") Long id);
}
