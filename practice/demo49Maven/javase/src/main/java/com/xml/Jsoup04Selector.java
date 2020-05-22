package com.xml;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup04Selector {
    public static void main(String[] args) throws IOException {
        String filename = Jsoup04Selector.class.getClassLoader().getResource("stu.xml").getPath();
        Document document = Jsoup.parse(new File(filename), "utf-8");
        Elements elements = document.select("name");
        for (Element element : elements) {
            System.out.println(element.text());
        }
        elements = document.select("students [number='02'] name");
        System.out.println("---------------------------------------");
        System.out.println(elements.text());
    }
}