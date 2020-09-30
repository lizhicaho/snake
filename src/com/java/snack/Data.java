package com.java.snack;

import javax.swing.*;
import java.net.URL;

//存放数据
public class Data {
     public static URL headerURL=Data.class.getResource("/static/header.png");//定位头图片地址
     public static URL uphead=Data.class.getResource("/static/up.png");//定位上头图片地址
     public static URL dowmhead=Data.class.getResource("/static/down.png");//定位下头图片地址
     public static URL lefthead=Data.class.getResource("/static/left.png");//定位左头图片地址
     public static URL righthead=Data.class.getResource("/static/right.png");//定位右头图片地址
     public static URL bodyUrl=Data.class.getResource("/static/body.png");//定位身体图片地址
     public static URL foodUrl=Data.class.getResource("/static/food.png");//定位食物图片地址
     public static ImageIcon header=new ImageIcon(headerURL);//图片
     public static ImageIcon upheader=new ImageIcon(uphead);//图片
     public static ImageIcon downheader=new ImageIcon(dowmhead);//图片
     public static ImageIcon leftheader=new ImageIcon(lefthead);//图片
     public static ImageIcon rightheader=new ImageIcon(righthead);//图片
     public static ImageIcon bodyer=new ImageIcon(bodyUrl);//图片
     public static ImageIcon fooder=new ImageIcon(foodUrl);//图片

     //蛇头
}
