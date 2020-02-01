package com.dyw.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        try {
            //创建sax读取对象
            SAXReader reader = new SAXReader();
            //指定解析文件
           Document document =  reader.read(new File("src/stus.xml"));
           //得到元素
            Element rootElement =  document.getRootElement();
            //获取子孙元素列表
            List<Element> elements = rootElement.elements();
            for (Element element : elements){
                String name = element.element("name").getText();
                String age =  element.element("id").getText();
                System.out.println("name="+name+"  id="+age);
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
