package com.xuecheng.manage_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.service.CmsConfigService;
import com.xuecheng.manage_cms.service.CmsTemplateService;
import com.xuecheng.manage_cms.service.PageService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticizeTest {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    PageService pageService;
    @Autowired
    CmsConfigService cmsConfigService;
    @Autowired
    CmsTemplateService cmsTemplateService;
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;

    @Test
    public void staticizeTest() throws IOException, TemplateException {
        // get DataUrl by cmspageId
        CmsPage cmsPageByID = pageService.findCmsPageByID("5f74846775c01809c0246684");
        String dataUrl = cmsPageByID.getDataUrl();
        String templateId = cmsPageByID.getTemplateId();
        String pagePhysicalPath = cmsPageByID.getPagePhysicalPath();
        String htmlFileId = cmsPageByID.getHtmlFileId();
//        System.out.println("dataUrl: " + dataUrl);
//        System.out.println("TemplateId: " + templateId);
        // get data model by DataUrl
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map model = forEntity.getBody();
        System.out.println(model);
        // get file_id
        String fileId = cmsTemplateService.queryCmsTemplateById(templateId).getTemplateFileId();
        System.out.println("fileId: " + fileId);
        // get template content
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        String content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        System.out.println("templare file content: " + content);
        // template content to template
        Configuration configuration = new Configuration(Configuration.getVersion());
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("index_banner", content);
        configuration.setTemplateLoader(stringTemplateLoader);
        Template template = configuration.getTemplate("index_banner", "utf-8");
        // staticize
        String staticContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        InputStream inputStream = IOUtils.toInputStream(staticContent);
        String staticFileName = pagePhysicalPath + htmlFileId + ".html";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(staticFileName));
        IOUtils.copy(inputStream, fileOutputStream);
        inputStream.close();
        fileOutputStream.close();

    }

}
