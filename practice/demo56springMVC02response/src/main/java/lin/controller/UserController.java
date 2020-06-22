package lin.controller;

import lin.domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(ModelMap modelMap) {
        System.out.println("testString.");
        User user = new User();
        user.setUsername("String");
        user.setPassword("123");
        user.setAge(20);
        modelMap.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");
        User user = new User();
        user.setUsername("ModelAndView");
        user.setPassword("123");
        user.setAge(20);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax");
        // client send ajax request with json String, and server saves the json to JavaBean
        System.out.println(user);
        // give response , could search data from database and return to client
        user.setPassword("123");
        user.setAge(17);
        return user;
    }

    //Use commons-upload component:
    @RequestMapping("/testUpload2")
    public String testUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {

        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path, filename));
        long uploadSize = upload.getSize();
        System.out.println("fileSize:" + uploadSize);
        System.out.println("new file: " + path + "\\" + filename);

        return "success";
    }

    // Use SpringMVC upload:
    @RequestMapping("/testUpload1")
    public String testUpload1(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem item : fileItems) {
            if (item.isFormField()){
                //说明是普通表单

            }else {
                //是上传文件项
                String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                item.write(new File(path,filename));
                item.delete();//删除临时文件
                System.out.println("new file: " + path + "\\" + filename);
            }
        }
        return "success";
    }
}
