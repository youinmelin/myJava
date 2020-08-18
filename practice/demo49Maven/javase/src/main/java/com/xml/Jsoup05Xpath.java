package com.xml;
/**
 * JsoupXpath.jar required
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;

public class Jsoup05Xpath {
    public static void main(String[] args) throws IOException {
        String fileName = Jsoup05Xpath.class.getClassLoader().getResource("stu.xml").getPath();
        Document doc = Jsoup.parse(new File(fileName), "utf-8");
        JXDocument jxDocument = new JXDocument(doc);
        List<JXNode> list = jxDocument.selN("//name");
        System.out.println(list);
    }
}