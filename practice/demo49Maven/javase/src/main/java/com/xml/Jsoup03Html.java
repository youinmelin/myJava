package com.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup03Html {
    public static void main(String[] args) {
        String html = "http://www.baidu.com";
        // html = "https://www.hlgnet.com";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
        Elements elements = doc.getElementsByTag("body");
        for (Element element : elements) {
            System.out.println(element.text());
        }
    }
}