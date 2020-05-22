package com.xml;

import java.io.File;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class Jsoup02Element {
    public static void main(String[] args) throws IOException {
        String path = Jsoup02Element.class.getClassLoader().getResource("stu.xml").getPath();
        Document doc = Jsoup.parse(new File(path), "utf-8");
        Elements numbers = doc.getElementsByAttribute("number");
        for (Element element : numbers) {
            System.out.println(element.text());
        }
        Elements names = doc.getElementsByTag("name");
        for (Element element : names) {
            System.out.println(element.text());
            
        }
    }
}