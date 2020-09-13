package lin.controller;

import com.github.pagehelper.PageInfo;
import lin.domain.Product;
import lin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"}) // 在方法前加注解，设置允许访问的用户权限
    public ModelAndView findAllProduct(Integer pageNum, Integer pageSize) throws Exception {
        System.out.println("pageNum: pageSize:" + pageNum + pageSize);
        System.out.println("USL:find all product");
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAllProduct(pageNum, pageSize);
        // pageInfo 是一个分页bean
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-page-list");
//        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product) throws Exception {
        System.out.println("USL: save Product.");
        productService.saveProduct(product);
        return "redirect:/product/findAll.do?pageNum=1&pageSize=5";

    }
}
