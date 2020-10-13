# spring boot
> 2020-7-11
## build a spring boot project
- 1.build a maven project
- 2. add dependency 
- 2.1.1 add parent project
```xml
 <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.6.RELEASE</version>
</parent>
```
- 2.1.2 add starter 
There are many starts in spring boot, now we add a web starter
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```
- 2.2 manage JDK version
```xml
    <properties>
        <java.version>1.8</java.version>
    </properties>
```
- 2.3 entire pom.xml file
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.leyou.demo</groupId>
    <artifactId>springboot-demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.0.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```
- 3. write Boot class and main method

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- 4.write Controller to test
```java
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello, spring boot!";
    }
}
```
- 5. run the main method and visit http://localhost:8080/hello

## annotation in spring boot
- `@Configuration` declare a class as a config class (as xml)
- `@Bean` declare a mehtod, add the method on spring container(as <bean>)
- `@Value` inject porperty
- `@PropertySource` declare a config file

## config a connection pool (druid)
 - 1.add connection pool dependency (druid)
 ```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.6</version>
</dependency>
 ```
 - 2.create a file named application.yml in classpath( such as resourses)
 ```yml
 jdbc: 
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql///dababase
    username: root
    password: root
 ```
- 3. build a config class (suce as JdbcConfig.java)
```java
@Configuration  // declare this is a config class
public class JdbcConfig {
    @Bean
    @ConfigurationProperties(prefix = "jdbc")  // tell boot to find config which prefix is jdbc in application.properties or application.yml
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
```
- 4. inject dataSource in Controller (suce as HelloController.java)
```java
@Controller
public class HelloController {
    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello() {
        System.out.println(dataSource);
        log.debug("hello method is running");
        return "hello,spring boot!";
    }
}
```

## spring boot config MVC
### spring boot default start tomcat, default port is 8080

- set configration in application.yml, can change port
    ```yml
    server:
        port: 80
    ```

- set log level
     ```yml
      logging:
        level:
            lin: debug  # package: level
     ```
- default static resource path
    - classpath:/META-INF/resources/
    - classpath:/resources/
    - classpath:/static/
    - classpath:/public

- add interceptor as log
    - 1. define log level in application.yml
    - 2. build a interceptor class which implements HandlerInterceptor
        ```java
        @Slf4j  // @Slf4j will help us create Logger object for recording log
        public class LoginInterceptor implements HandlerInterceptor {

            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
                log.debug("preHandle method is now running!");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
                log.debug("postHandle method is now running!");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
                log.debug("afterCompletion method is now running!");
            }
        }
        ```
    - 3. build a config class(MVCCongig.java) to register our interceptor
        ```java
            @Configuration
            public class MvcConfig implements WebMvcConfigurer {
                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor()); // add interceptor
                    interceptorRegistration.addPathPatterns("/**"); // add interceptor path
                }
            }
        ```
    - use HikariCP connection pool
        - 1. add dependency 
              如果用通用Mapper，jdbc starter and mybatis starter 就不用引入了，
              只需要引入mysql依赖
        - 2. config connection pool in application.yml
        - 3. config mybatis in application.yml and add `@MapperScan` in boot class
              如果用通用Mapper，`@MapperScan`注解不能再import mybatis，而是要 ```import tk.mybatis.spring.annotation.MapperScan; ```
        - 4. 通用Mapper starter
              功能：自动实现单表增删改查CRUD操作
            ```xml
            <!-- 通用mapper -->
            <dependency>
                <groupId>tk.mybatis</groupId>
                <artifactId>mapper-spring-boot-starter</artifactId>
                <version>2.0.2</version>
            </dependency>
            ```
        - 5. build Mapper(Dao) interface extends Mapper<pojo class>
            ```java 
                import tk.mybatis.mapper.common.Mapper;
            ```
        - 6. 在pojo class 前加注解`@Table(name = "tableName")`
              在主键对应的属性上加注解：`@Id`
              自增主键上加注解：`@KeySql(useGeneratedKeys = true)`
              在不需要持久化的属性上加注解: `@Transient`,就不会作为sql语句的字段
        - 7. 事务
        在service层需要的方法上加注解：`@Transactional`
        - 8. Controller code
            ```java
            @Slf4j // 自动创建Logger对象
            @RestController
            @RequestMapping("/user")
            public class HelloController {

                @Autowired
                private UserService userService;

                @GetMapping("{id}") // url = "localhost/user/{id value}
                public User hello(@PathVariable("id") Long id) {
                    log.debug("hello method is running");
                    return userService.selectUserById(id);  // return a json data
                }
            ```

# Spring Cloud 微服务架构

## RestTempla
    通过使用RestTempla模板工具类，实现数据的远程调用，支持：
    - HttpClient
    - OkHttp
    - JDK原生的URLConnection（默认的）
    1. 在项目中注册一个`RestTemplate`对象，可以在启动类位置注册：
```java
@SpringBootApplication
public class HttpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
		return new RestTemplate();
	}
}
```
    2. 在Controller层调用
```java
    @RestController
        @RequestMapping("/consumer")
        public class ConsumerController {

            @Autowired
            private RestTemplate restTemplate;

            @GetMapping("{id}")
            public User queryById(@PathVariable("id") Long id) {
                String url = "http://localhost:8081/user/" + id;
                return restTemplate.getForObject(url,User.class);
            }
        }
```
## Eureka 

 ###  in server
 - 1. add dependency
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        <version></version>
    </dependency>
   ```
 - 2. 编写启动类：

    ```java
    @SpringBootApplication
    @EnableEurekaServer // 声明这个应用是一个EurekaServer
    public class EurekaDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(EurekaDemoApplication.class, args);
        }
    }
   ```

- 3. 编写配置：

    ```yml
        server:
        port: 10086 # 端口
        spring:
        application:
            name: eureka-server # 应用名称，会在Eureka中显示
        eureka:
        client:
            register-with-eureka: false # 是否注册自己的信息到EurekaServer，默认是true
            fetch-registry: false # 是否拉取其它服务的信息，默认是true
            service-url: # EurekaServer的地址，现在是自己的地址，如果是集群，需要加上其它Server的地址。
            defaultZone: http://127.0.0.1:${server.port}/eureka # 要注册到哪个eureka service

    ```

- 4. 启动服务，并访问：http://127.0.0.1:10086/eureka


 ###  将user-service注册到Eureka
 - 1. add dependency
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version></version>
    </dependency>
   ```
 - 2. 编写启动类：

   ```java
    @SpringBootApplication
    @EnableDiscoveryClient // 声明这个应用是一个Client (not only for eureka)
    public class EurekaDemoApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(EurekaDemoApplication.class, args);
        }
   ```

- 3. 编写配置：
    ```yaml
    server:
    port: 8081
    spring:
    datasource:
        url: jdbc:mysql://localhost:3306/mydb01
        username: root
        password: 123
        hikari:
        maximum-pool-size: 20
        minimum-idle: 10
    application:
        name: user-service # 应用名称
    mybatis:
    type-aliases-package: com.leyou.userservice.pojo
    eureka:
      client:
        service-url: # EurekaServer地址
        defaultZone: http://127.0.0.1:10086/eureka
    instance:
        prefer-ip-address: true # 当调用getHostname获取实例的hostname时，返回ip而不是host名称
        ip-address: 127.0.0.1 # 指定自己的ip信息，不指定的话会自己寻找
    ```

### 消费者从Eureka获取服务

接下来我们修改consumer-demo，尝试从EurekaServer获取服务。

方法与消费者类似，只需要在项目中添加EurekaClient依赖，就可以通过服务名称来获取信息了！

- 1）添加依赖：

先添加SpringCloud依赖：

```xml
<!-- SpringCloud的依赖 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.RC1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<!-- Spring的仓库地址 -->
<repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

然后是Eureka客户端：

```xml
<!-- Eureka客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```



- 2）在启动类开启Eureka客户端

```java
@SpringBootApplication
@EnableDiscoveryClient // 开启Eureka客户端
public class UserConsumerDemoApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerDemoApplication.class, args);
    }
}

```

- 3）修改配置：

```yaml
server:
  port: 8081
spring:
  application:
    name: consumer # 应用名称
eureka:
  client:
    service-url: # EurekaServer地址，是KV形式的写在下一行
      defaultZone: http://127.0.0.1:10086/eureka
  instance:
    prefer-ip-address: true # 当其它服务获取地址时提供ip而不是hostname
    ip-address: 127.0.0.1 # 指定自己的ip信息，不指定的话会自己寻找
```

- 4）修改代码，用DiscoveryClient类的方法，根据服务名称，获取服务实例：

```java
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        // String baseUrl = "http://localhost:8081/user/";
        // 根据服务名称(serve id)，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息 from eureka server
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
        ids.forEach(id -> {
            // 我们测试多次查询，
            users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
            // 每次间隔500毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return users;
    }
}
```

总结：
- 建立了eureka注册中心服务器（单）和客户端也就是微服务器（单）
    使用 DiscoveryClient类中的descoveryClient方法，获取客户端实例List
- 建立eureka多个注册中心服务器， 多个客户端可以对应同一个服务名称(application)（目的是负载均衡），但是每一个客户端对应一个实例(instance)
    steps:
    1. 在application.yml的eureka.client中互相注册为客户端
    2. 客户端的defanultZone中要将所有服务器地址都写上，用逗号分开

## Eureka详解
2020-7-12
> 服务续约

在注册服务完成以后，服务提供者会维持一个心跳（定时向EurekaServer发起Rest请求），告诉EurekaServer：“我还活着”。
这个我们称为服务的续约（renew）；

有两个重要参数可以修改服务续约的行为：

```yaml
eureka:
  instance:
    lease-renewal-interval-in-seconds: 30
    lease-expiration-duration-in-seconds: 90
```
> 获取服务列表

当服务消费者启动是，会检测`eureka.client.fetch-registry=true`参数的值，如果为true，则会从Eureka Server服务的列表只读备份，然后缓存在本地。并且`每隔30秒`会重新获取并更新数据。我们可以通过下面的参数来修改：

```yaml
eureka:
  client:
    registry-fetch-interval-seconds: 5
```
> 失效剔除

有些时候，我们的服务提供方并不一定会正常下线，可能因为内存溢出、网络故障等原因导致服务无法正常工作。Eureka Server需要将这样的服务剔除出服务列表。因此它会开启一个定时任务，每隔60秒对所有失效的服务（超过90秒未响应）进行剔除。

可以通过`eureka.server.eviction-interval-timer-in-ms`参数对其进行修改，单位是毫秒，生成环境不要修改。

## ribbon (automatic load balance)
tips: add one service in idea:
    Run/Debug Configurations-->copy a service-->Configuration-->Environment-->VM options:-Dserver.port=8081
    set JVM 

use ribbon:
- 方法 1. add dependency:
spring-cloud-starter-netflix-ribbon
使用RibbonLoadBalancerClient类中的chooce方法，从instance列表中自动获取一个instance对象，供调用
- 方法 2 不用导入ribbon依赖，而是利用注解：
- 2.1 add annotation `@LoadBalanced` on RestTemplate的配置方法
  
    ```java
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    ```
- 2.2 use method
    ```java
    @RestController
    @GetMapping("/user")
    public class UserController {

        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("{id}")
        public User queryUserById(@PathVariable("id") Long id) {
            // 地址直接写服务名称(server id)即可
            String serivceName = "user-service"; //想要调用的服务ID
            // robbin 内部的拦截器会自动将serviceName转换成uri
            String baseUrl= "http://" + serivceName + "/user/" + id;
            User user = restTemplate.getForObject(baseUrl, User.class);
            return user;
        }
    }
    ```
总结：
    使用场景：同一个功能的微服务使用多个实例，调用微服务时，通过ribbon每次调用不同的实例，实现负载均衡。ribbon要在consummer端使用,调用服务提供端.

## Hystrix  线程隔离,服务降级
2020-7-14
Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable. 
熔断器  a componet of Netflix, defend your App
Hystix是Netflix开源的一个延迟和容错库，用于隔离访问远程服务、第三方库，防止出现级联失败。当服务繁忙时，如果服务出现异常，不是粗暴的直接报错，而是返回一个友好的提示，虽然拒绝了用户的访问，但是会返回一个结果。

### failure dealing 降级
use steps:
- 1. add dependency in consumer
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    </dependency>
    ```
- 2. 2.1 add annotation on boot class of consumer
        `@EnableCircuitBreaker`
      tips: if use`@SpringCloudApplication` on the boot class, then can not use `@EnableCircuitBreaker` + `@SpringBootApplication` + `@EnableDiscoveryClient`.
  
  2.2A declare method 
    2.2A.1 add an annotation `@HystrixCommand(fallbackMethod = "failMethodName")` on succeed method to define failure method name
    2.2A.2 declare the method
      two methods must have same return type and arguments list
    ```java
    @Component
    public class UserDao {
  
      @Autowired
        private RestTemplate restTemplate;
  
      @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
        public User queryUserById(Long id){
            String url = "http://user-service/user/" + id;
            User user = this.restTemplate.getForObject(url, User.class);
            return user;
        }
  
      public User queryUserByIdFallback(Long id){
            User user = new User();
            user.setId(id);
            user.setName("用户信息查询出现异常！");
            return user;
        }
    }
    ```
    - set time out value:
        ```java
            @HystrixCommand(commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            })
        ```
  
  2.2B declare the class
    besides declare on the method, we can declare on the class
    2.2B.1 add an annotation `@DefaultProperties(defaultFallback = "defaultFallback")`on class of consumer
    2.2B.2 add an annotation `@HystrixCommand()` on success method
    2.2B.3 declare failure method (defaultFallback)
    method defaultFallback must not have argument
  
  
  
- 3. set application.yml (can be igorned)
我们可以通过`hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds`来设置Hystrix超时时间。default time out is 1000ms

```yaml
hystrix:
  command:
  	default:
        execution:
          isolation:
            thread:
              timeoutInMillisecond: 3000 # 设置hystrix的超时时间为6000ms
```

### Hystrix 熔断 Circuit breaker
threshold reached
 under threshold
 call/raise circuit open
 Closed-->Open-->Half Open

- set circuit breaker value, add an annotation on the method:
    ```java
        @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindwoInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
        })
    ```

## OpenFeign
Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it.
Feign可以把Rest的请求进行隐藏，伪装成类似SpringMVC的Controller一样。你不用再自己拼接url，拼接参数等等操作，一切都交给Feign去做。
how to use
steps:
- add dependency
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
    ```
- 1. add an annotation on boot class of consummer
`@EnableFeignClients`
- 2. code a interface UserClient as feign client
 define 
 (1. require type (`@GetMapping()`,`@PostMapping()`)
 (2. require path (`@GetMapping("path")`,`@PostMapping("path")` )
 (3. require arguments;
 (4. return value type.
 (5. service name (`@FeignClient`)

```java
@FeignClient("user-service")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User queryUserById(@PathVariable("id") Long id);
}
```

    - 首先这是一个接口，Feign会通过动态代理，帮我们生成实现类。这点跟mybatis的mapper很像 `@FeignClient`，声明这是一个Feign客户端，类似`@Mapper`注解。同时通过`value`属性指定服务名称
    - 接口中的定义方法，完全采用SpringMVC的注解，Feign会根据注解帮我们生成URL，并访问获取结果
- 3. inject the interface on consumer class
don't need to use RestTemplate class
neither need to use ribbon and hystrix.
```java
    @Service
    public class UserService {

        @Autowired
        private UserFeignClient userFeignClient;

        public User queryUserById(Long id) {
            user = userFeignClient.queryUserById(id));
            return user;
        }
    }
```
notes:
> feign include ribbon
 set ribbon in application.yml
```yaml
  ribbon:
    ConnectTimeout: 250 # 连接超时时间(ms)
    ReadTimeout: 1000 # 通信超时时间(ms)
    OkToRetryOnAllOperations: true # 是否对所有操作重试
    MaxAutoRetriesNextServer: 1 # 同一服务不同实例的重试次数
    MaxAutoRetries: 1 # 同一实例的重试次数
```
> feign include hystrix (default close) 
- 1. set hystrix in application.yml

```yaml
feign:
  hystrix:
    enabled: true # 开启Feign的熔断功能
```
- 2. add `@EnableCircuitBreaker`
- 3. Feign中的Fallback配置不像Ribbon中那样简单了。(也可以单独使用hystrix)

    1）首先，我们要定义一个类，实现刚才编写的UserFeignClient interface，作为fallback的处理类

    ```java
    @Component
    public class UserFeignClientFallback implements UserFeignClient {
        @Override
        public User queryUserById(Long id) {
            User user = new User();
            user.setId(id);
            user.setName("用户查询出现异常！");
            return user;
        }
    }

    ```

    2）然后在UserFeignClient中，指定刚才编写的实现类

    ```java
    @FeignClient(value = "user-service", fallback = UserFeignClientFallback.class)
    public interface UserFeignClient {

        @GetMapping("/user/{id}")
        User queryUserById(@PathVariable("id") Long id);
    }

    ```
## Zuul net gate by netflix
 To use Netflix Zuul API gateway we have to follow below steps:

    Add required dependency in your pom.xml file.
    Use @EnableZuulProxy annotation in your main class.
    Register this Zuul API gateway application With Eureka Server.
    Provide routing endPoints property in your application.properties file.
    Run Eureka Server and all other application and use your zuul gateway url to access all other application end Points.
### 路由
build a zuul service steps:
- 1. add dependency
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
    </dependency>
    zuul starter dependency includes starter-web, hystrix, ribbon ... 
    ```
- 2. code a boot class with `@EnableZuulProxy`
```java
@SpringBootApplication
@EnableZuulProxy // 开启Zuul的网关功能
public class ZuulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulDemoApplication.class, args);
	}
}
```
- 3A. mapping other address but not use load balance
application.yml
```yaml
server:
  port: 10010 # server port
spring: 
  application:  
    name: api-gateway # server name
zuul:
  routes:  # role of route(<Map>)
    path: /user/** # mapping path
    url: http://127.0.0.1:8081  # real url of mapping path
```
- 3B. mapping other service with load balance by using eureka
- 3B.1. add dependency of eureka client
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
    2. add eureka config in application.yml
```yaml
eureka:
  client:
    registry-fetch-interval-seconds: 5 # 获取服务列表的周期：5s
    service-url:
      defaultZone: http://127.0.0.1:10086/eureka
  instance:
    prefer-ip-address: true
    ip-address: 127.0.0.1
zuul:
  routes:
    user-service-id: # 这里是路由id，随意写
      path: /user-service/** # 这里是映射路径
      serviceId: user-service # 指定服务名称
    user-service: /user-service/** # can also write like that for one line : serviceId: /serviceName/**
```
> 默认的路由规则

在使用Zuul的过程中，Zuul指定了默认的路由规则：

- 默认情况下，一切服务的映射路径就是服务名本身。
  - 例如服务名为：`user-service`，则默认的映射路径就是：`/user-service/**`

也就是说，刚才的映射规则我们完全不配置也是OK的。

> if some services don't want to be mapping, add their serviceId into ignored list on application.yml
```yaml
zuul:
  ignored-services: # can not be seen by the browser client
    - consumer-service
    - user-service
```
- route perfix
```yml 
zuul:
  routes:
    user-service-id: # 这里是路由id，随意写
      path: /user-service/** # 这里是映射路径
      serviceId: user-service # 指定服务名称
      strip-prefix: false # strip prefix when input url in browser
```
### 过滤器 filter
ZuulFilter是过滤器的顶级父类。在这里我们看一下其中定义的4个最重要的方法：

```java
public abstract ZuulFilter implements IZuulFilter{

    abstract public String filterType();

    abstract public int filterOrder();
    
    boolean shouldFilter();// 来自IZuulFilter

    Object run() throws ZuulException;// IZuulFilter
}
```

- `shouldFilter`：返回一个`Boolean`值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
- `run`：过滤器的具体业务逻辑。
- `filterType`：返回字符串，代表过滤器的类型。包含以下4种：
  - `pre`：请求在被路由之前执行
  - `routing`：在路由请求时调用
  - `post`：在routing和errror过滤器之后调用
  - `error`：处理请求时发生错误调用
- `filterOrder`：通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
> how to use:
自定义过滤器

接下来我们来自定义一个过滤器，模拟一个登录的校验。基本逻辑：如果请求中有access-token参数，则认为请求有效，放行。

定义过滤器类entends ZuulFilter，zuul会自动加载

```java
@Component
public class LoginFilter extends ZuulFilter{
    @Override
    public String filterType() {
        // 登录校验，肯定是在前置拦截
        // return "pre";
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 顺序设置为1
        // return 1;
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;   
    }

    @Override
    public boolean shouldFilter() {
        // 返回true，代表过滤器生效。
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 登录校验逻辑。
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getParameter("access-token");
        // 4) 判断
        if(token == null || "".equals(token.trim())){
            // 没有token，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return null;
    }
}

```
### 负载均衡和熔断

Zuul中默认就已经集成了Ribbon负载均衡和Hystix熔断机制。但是所有的超时策略都是走的默认值，比如熔断超时时间只有1S，很容易就触发了。因此建议我们手动进行配置：

```yaml
zuul:
  retryable: true
ribbon:
  ConnectTimeout: 250 # 连接超时时间(ms)
  ReadTimeout: 2000 # 通信超时时间(ms)
  OkToRetryOnAllOperations: true # 是否对所有操作重试
  MaxAutoRetriesNextServer: 1 # 同一服务不同实例的重试次数
  MaxAutoRetries: 0 # 同一实例的重试次数
hystrix:
  command:
  	default:
        execution:
          isolation:
            thread:
              timeoutInMillisecond: 6000 # 熔断超时时长： (ConnectTimeout + ReadTimeout)*2<=timeoutInMillisecond
```

## summarize:
> in spring cloud, there are some components:
>
> - eureka:  Eureka is the Netflix Service Discovery Server and Client. The server can be configured and deployed to be highly available, with each server replicating state about the registered services to the others.
- ribbon: Ribbon is a client-side load balancer that gives you a lot of control over the behavior of HTTP and TCP clients.
- hystix: Hystrix is a fault tolerance library and is used as strategy against failures (at different levels) in a service-layer.
- feign: Feign is a declarative web service client. It makes writing web service clients easier. Feign has to be registered against Eureka server so it knows which are the other microservices available and their names in order to be able to reach them.
- zuul: Router and Filter
- spring-cloud-config
- spring-cloud-bus
- spring-cloud-streat
- spring-cloud-hystrix-dashboard
- spring-cloud-sleuth

# ES6
```html
    <script>
        // let declares local variable
        for (let index = 0; index < 5; index++) {
            console.log("index: " +  index);
        }

        let arr = [1,2,3,4,5];
        // get some values from array
        let [a,b,,,c] = arr;
        console.log("a: " + a);
        console.log("b: " + b);
        console.log("c: " + c);
        // get all values from array except the frist
        let[,...rest] = arr;
        console.log(rest);
        // get values from object
        let p = {name: "jack", age: 21};
        console.log(p.name);
        let{name:newName,age} = p;
        console.log("name: " + newName + "  age:" + age);

        // lamda in JS
        const add = (a,b) => a + b;
        let sum = add(1,2);
        console.log("a+b:" + sum);

        // const person = {
        //     name:"jack",
        //     age: 21
        // }

        let sayHello = ()  => console.log("hello ES6");
        sayHello();

        // map()
        let arr2 = ['2', '5', '10'];
        arr2Int = arr2.map(s => parseInt(s));
        console.log(arr2Int);
        //reduce()
        let result = arr2Int.reduce((a,b) => a + b);
        console.log(result);
    </script>
```
# Vue
## install
- install node.js
then:
node -v
npm -v
can show the visions
- install nrm (set mirrors)
npm install nrm -g // for globle
nrm ls (show mirrors)
nrm test npm
nrm use taobao
nrm test taobao
notes: restart pc after install
## use Vue
- build a new project in idea
    build empty project
- new module -> add Static Web (Ex. vue-demo)
- cd vue-demo
- input command "npm init -y" in terminal, then there will be a new file--"package.json"
- npm install vue --save // for current project, then there will be a new folder --"node_modules"

```html
<div id="app">
    <h2><span v-text="hello"></span> 非常帅</h2>
</div>
<script src="./node_modules/vue/dist/vue.js"></script>
<script type="text/javascript">
    // 生成一个Vue实例
    var app = new Vue({
        el:"#app", // el,即element。要渲染的的页面元素
        data:{ // 数据
            name:"虎哥"
        },
        created(){  // change value of name
            this.name = "hello, world！ ";
            console.log(this);
        }
    })
</script>
```
> v-text和v-html单向绑定，数据影响了视图渲染(model->view)

使用v-text和v-html指令来替代`{{}}`

说明：

- v-text：将数据输出到元素内部，如果输出的数据有HTML代码，会作为普通文本输出
- v-html：将数据输出到元素内部，如果输出的数据有HTML代码，会被渲染
> v-model是双向绑定，视图（View）和模型（Model）之间会互相影响。
v-model的可使用元素有：

- input
- select
- textarea
- checkbox
- radio
- components（Vue中的自定义组件）


```html
<div id="app">
    <input type="checkbox" v-model="language" value="Java" />Java<br/>
    <input type="checkbox" v-model="language" value="PHP" />PHP<br/>
    <input type="checkbox" v-model="language" value="Swift" />Swift<br/>
    <h1>
        你选择了：{{language.join(',')}}
    </h1>
</div>
<script src="./node_modules/vue/dist/vue.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            language: []
        }
    })
</script>
```

- 多个`CheckBox`对应一个model时，model的类型是一个数组，单个checkbox值是boolean类型
- radio对应的值是input的value值
- `input` 和`textarea` 默认对应的model是字符串
- `select`单选对应字符串，多选对应也是数组

- v-on指令用于给页面元素绑定事件。事件绑定可以简写，例如`v-on:click='add'`可以简写为`@click='add'`
语法：

```
v-on:事件名="js片段或函数名"
```

示例：

```html
<div id="app">
    <!--事件中直接写js片段-->
    <button v-on:click="num++">增加</button><br/>
    <!--事件指定一个回调函数，必须是Vue实例中定义的函数-->
    <button v-on:click="decrement">减少</button><br/>
    <h1>num: {{num}}</h1>
</div>
<script src="./node_modules/vue/dist/vue.js"></script>
<script type="text/javascript">
    var app = new Vue({
        el:"#app",
        data:{
            num:1
        },
        methods:{
            decrement(){
                this.num--;
            }
        }
    })
</script>
```

- 遍历数据渲染页面是非常常用的需求，Vue中通过v-for指令来实现。
```html
<div id="app">
    <ul>
        <li v-for="(user,index) in users">
            {{index} : {user.name}} : {{user.gender}} : {{user.age}}
        </li>
    </ul>
</div>
<script src="./node_modules/vue/dist/vue.js"></script>
<script type="text/javascript">
    var vm = new Vue({
        el:"#app",
        data:{
            users:[
                {name:'柳岩', gender:'女', age: 21},
                {name:'虎哥', gender:'男', age: 30},
                {name:'范冰冰', gender:'女', age: 24},
                {name:'刘亦菲', gender:'女', age: 18},
                {name:'古力娜扎', gender:'女', age: 25}
            ]
        }
    })
</script>
```

v-if
v-else
v-else-if
v-show
v-bind

Vue中提供了计算属性，来替代复杂的表达式：

```js
var vm = new Vue({
    el:"#app",
    data:{
        birthday:1429032123201 // 毫秒值
    },
    computed:{
        birth(){// 计算属性本质是一个方法，但是必须返回结果
            const d = new Date(this.birthday);
            return d.getFullYear() + "-" + d.getMonth() + "-" + d.getDay();
        }
    }
})
```


## vue-cli
in cmd:npm install -g vue-cli
create a new static project or module 
in idea terminal: vue init webpack
```shell
    ? Install vue-router? Yes
    ? Use ESLint to lint your code? No
    ? Set up unit tests No
    ? Setup e2e tests with Nightwatch? No
    ? Should we run `npm install` for you after the project has been created? (recommended) npm
```
To get started:

  npm run dev

# create a e-shop microservice project
## registry-eureka
## gateway- zuul
## create a parent project for item
### create a son project as item interface(parent is item)
### create a son project as item service(parent is item)
## create a project for common function

