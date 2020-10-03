package com.xuecheng.manage_cms_client.mq;

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms_client.dao.CmsPageRepository;
import com.xuecheng.manage_cms_client.service.PageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
Rabbitmq 消费者,当接收到含有pageId的消息后,执行程序,
让指定队列的cms client服务器从GridFS服务器下载相应的文件
 */
@Component
public class ConsumerPostPage {
    @Autowired
    PageService pageService;
    @Autowired
    CmsPageRepository cmsPageRepository;

    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void postPage(String messageStr) {
        System.out.println(messageStr);
        // 解析json格式的消息
        Map map = JSON.parseObject(messageStr, Map.class);
        // 取出pageID
        String pageID = (String) map.get("pageId");
        // 查询页面信息,验证是否存在该信息
//        if (!cmsPageRepository.findById(pageID).isPresent()) {
//            return;
//        }
        // 将页面保存到cms client服务器
        pageService.savePageToServicePath(pageID);

    }

}
