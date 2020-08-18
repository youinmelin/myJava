package com.xml;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class jsoup01 {
    public static void main(String[] args) throws IOException {

        // get path of the file
        String html = jsoup01.class.getClassLoader().getResource("stu.xml").getPath();
        System.out.println(html);

        // parse xml file, add file into ram, get DOM
        Document doc = Jsoup.parse(new File(html),"utf-8");

        // get element objects
        Elements elements = doc.getElementsByTag("name");
        System.out.println(elements.first().text());
    }
}