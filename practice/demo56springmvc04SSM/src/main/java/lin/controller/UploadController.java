package lin.controller;

import lin.dao.IFileMsgDao;
import lin.domain.FilenameAndMsg;
import lin.exception.SysException;
import lin.service.IAccountService;
import lin.service.IFileMsgService;
import lin.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IFileMsgService fileMsgService;

    private final String UPLOADPATH = "/upload";


    /**
     * upload file , create FilenameAndMsg object, save infomation into database
     */
    @RequestMapping("/uploadFileMsg")
    public String uploadFileAndMsg(HttpServletRequest request, HttpServletResponse response, MultipartFile upload, Integer uId, String username,  String msg) throws SysException {

        String path = request.getSession().getServletContext().getRealPath(UPLOADPATH);
        String filename = null;
        System.out.println("path:" + path);
        File file = new File(path);
        makedir(file);
        try {
            filename = upload.getOriginalFilename();
            // change filename
            if (!filename.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String date = dateFormat.format(new Date());
                filename = username + "-" + date + "-" + filename;
                  //  change "%#&^" into other char, because if these chars are in filename, thses files can not download.
                filename = StringUtils.changeSign(filename);
            }
            if (upload.getSize() > 1024*1024*50) {
                throw new SysException("文件太大，最大50M");
            }
            upload.transferTo(new File(path, filename));
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("no filename");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println("contextpath: "+request.getContextPath() + UPLOADPATH );
        System.out.println("file size:" + upload.getSize()/1024 + "k");
        System.out.println(path + "\\" + filename);

        // turn filesize from byte to M
        int filesize = (int) (upload.getSize()/1024/1024);
        // if msg is empty, then filename is msg
        msg = msg.equals("")?filename:msg;
        System.out.println("userId: " + uId + "  msg: " + msg);
        // create FilenameAndMsg object
        FilenameAndMsg filemsg = new FilenameAndMsg(null, uId, msg, filename, filesize, new Date());
        System.out.println("USL: " + filemsg);
        // save to database
        fileMsgService.saveFileMsg(filemsg);
         try {
//             response.sendRedirect(request.getContextPath() + "/upload/findAllFileMsgWithUser");
             response.sendRedirect( "/upload/findAllFileMsgWithUser");
         } catch (IOException e) {
             e.printStackTrace();
         }
         return "success";
    }


//    @RequestMapping("/findAllFileMsg")
//    public ModelAndView findAllFileMsg(ModelAndView mv, HttpServletResponse response) throws IOException {
//        System.out.println("USL: find all file msg");
//        List<FilenameAndMsg> allFileMsg = fileMsgService.findAllFileMsg();
//        mv.addObject("fileMsgList", allFileMsg);
//        mv.setViewName("../../index");
//        return mv;
//    }

    @RequestMapping("/findAllFileMsgWithUser")
    public ModelAndView findAllFileMsgWithUser(ModelAndView mv, Integer currentPage, Integer numPerPage) {
        System.out.println("USL: find all file msg with user");
        if (currentPage == null) {
            currentPage = 1;
            numPerPage = 10;
        }
//        Integer
        Integer count = fileMsgService.findMsgCount();
        int countPages = count/numPerPage;
        if (count%numPerPage>0) {
            countPages++;
        }
        Integer currentFirstIndex = (currentPage-1)*numPerPage;
        List<FilenameAndMsg> allFileMsg = fileMsgService.findMsgWithUser(currentFirstIndex, numPerPage);
        for (FilenameAndMsg msg : allFileMsg) {
            msg.setDatetimeStr(msg.getDatetime());
        }
        mv.addObject("fileMsgList", allFileMsg);
        mv.addObject("count", count);
        mv.addObject("countPages", countPages);
        mv.addObject("currentPage", currentPage);
        mv.setViewName("../../index");
        return mv;
    }
    /**
     * file downloader not use
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(String filename, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("USL: download file + filename");
        // config response header: download
        response.setHeader("Content-Disposition", "attachment;filename" + filename);
        // get outputStream
        ServletOutputStream os = response.getOutputStream();
        // get file's absolute path
        String path = request.getSession().getServletContext().getRealPath(UPLOADPATH);
        // create files list
        System.out.println(filename);
        File file = new File(path, filename);
        // turn the file to byte[]
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
        os.write(readFileToByteArray);
        os.flush();
        os.close();

    }

    /**
     * download file (use well)
     */
    @RequestMapping(value ="/DownloadFile")
    public ResponseEntity<byte[]> DownloadFile(String filename, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SysException {
        //  接受的是UTF-8
        req.setCharacterEncoding("utf-8");
        //获取项目根目录
        String path = req.getSession().getServletContext().getRealPath(UPLOADPATH + "\\" + filename);
//        System.out.println("download file path: " + path);
//        System.out.println("path: " + path);
        //获取文件名
        File file = null;
        HttpHeaders headers = null;
        ResponseEntity<byte[]> responseEntity;
        try {
//            System.out.println("filename:" + filename);//myfiles
            file = new File(path);
            //请求头
            headers = new HttpHeaders();
            String fileName1 = new String(filename.getBytes("UTF-8"), "iso-8859-1");//解决文件名乱码
            //通知浏览器以attachment（下载方式）打开
            headers.setContentDispositionFormData("attachment", fileName1);
            //application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            System.out.println("filename:" + filename);//myfiles
            responseEntity = new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
            System.out.println("filename again:" + filename);//myfiles
        } catch (Exception e) {
//            throw new RuntimeException(e);
            // 抛出自定义类SysException
            throw new SysException("该文件不存在。");
        }
        return responseEntity;
    }

    @RequestMapping("/delFileByMsgId")
    public String delFileByMsgId(Integer msgId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String filename = fileMsgService.delFileByMsgId(msgId);
        String path = request.getSession().getServletContext().getRealPath(UPLOADPATH);
        boolean isDeleted =  delFile(new File(path + "\\" + filename));
        if (isDeleted) {
            System.out.println("deleted "+ path + "\\" + filename +" sucessfully.");
        }else {
            System.out.println("deleted "+ path + "\\" + filename +" failed.");
        }
        response.sendRedirect( "/upload/findAllFileMsgWithUser");
        return "success";

    }
    private boolean makedir(File file) {
        if (!file.exists()) {
            System.out.println("mkdirs");
            return file.mkdirs();
        }else {
            return false;
        }
    }

    private boolean delFile(File file) {
        if (file.exists()) {
            System.out.println("del file");
//            System.out.println(file.getPath());
            return file.delete();
        }else {
            return false;
        }
    }

}
