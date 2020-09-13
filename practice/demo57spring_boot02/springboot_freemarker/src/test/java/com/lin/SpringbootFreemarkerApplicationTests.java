package com.lin;

import com.lin.pojo.Student;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootFreemarkerApplicationTests {

	@Test
	void contextLoads() {
	}

	// 测试页面静态化，基于<<ftlh模板文件>>自动生成html文件,并非使用与spring boot结合方式
	@Test
	public void testGenerateHtml () throws IOException, TemplateException {
		// 定义配置类 import freemarker.template.Configuration;
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 定义模板
		// get path of class
		String path = this.getClass().getResource("/").getPath();
		// 定义模板path
		configuration.setDirectoryForTemplateLoading(new File(path + "/templates/"));
		// get contents of template file 获取模板对象
		Template template = configuration.getTemplate("freemarker_test4.ftlh");
		// 定义数据模型
        Map map = getMap();
		// 静态化
		// 将模板转换为字符串
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		System.out.println(content);
		// 建立输入流
		InputStream inputStream = IOUtils.toInputStream(content);
		// 输出到文件
		FileOutputStream outputStream = new FileOutputStream(new File( "d:/test1.html"));
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}

	// 测试页面静态化，基于模板内容（字符串）自动生成html文件,并非使用与spring boot结合方式
	@Test
	public void testGenerateHtmlByString () throws IOException, TemplateException {
		// 定义配置类 import freemarker.template.Configuration;
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 定义模板
			// 模板内容（字符串） 来自于用户输入或者其他文件
		String templateString = "" + "<html>\n"+"<head></head>\n"+"<body>\n"+"名称：${name}\n"+"</body>\n"+"</html>";
            // 使用模板加载器，使字符串变为模板
		StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
		stringTemplateLoader.putTemplate("template1", templateString);
			// 在配置对象当中设置模板加载器
		configuration.setTemplateLoader(stringTemplateLoader);
			// 获取模板内容
		Template template = configuration.getTemplate("template1", "utf-8");
		// 定义数据模型
		Map map = getMap();
		// 静态化
		// 将模板转换为字符串
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		System.out.println(content);
		// 建立输入流
		InputStream inputStream = IOUtils.toInputStream(content);
		// 输出到文件
		FileOutputStream outputStream = new FileOutputStream(new File( "d:/test1.html"));
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
    }


	// 获取数据模型
	public Map getMap() {
		Map map = new HashMap<>();
		map.put("name","黑马程序员");
		Student stu1 = new Student();
		stu1.setName("小明");
		stu1.setAge(18);
		stu1.setMoney(1000.86f);
		stu1.setBirthday(new Date());
		Student stu2 = new Student();
		stu2.setName("小红");
		stu2.setMoney(200.1f);
		stu2.setAge(19);
//        stu2.setBirthday(new Date());
		List<Student> friends = new ArrayList<>();
		friends.add(stu1);
		stu2.setFriends(friends);
		stu2.setBestFriend(stu1);
		List<Student> stus = new ArrayList<>();
		stus.add(stu1);
		stus.add(stu2);
		//向数据模型放数据
		map.put("stus",stus);
		//准备map数据
		HashMap<String,Student> stuMap = new HashMap<>();
		stuMap.put("stu1",stu1);
		stuMap.put("stu2",stu2);
		//向数据模型放数据
		map.put("stu1",stu1);
		//向数据模型放数据
		map.put("stuMap",stuMap);
		//返回模板文件名称
		return map;
	}
}
