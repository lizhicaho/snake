package com.java.snack;

import javax.swing.*;

public class StartGames {
    //1.绘制静态窗口
    public static void main(String[] args) {
        JFrame f=new JFrame("贪吃蛇WOW");
        //设置窗口大小·
        f.setBounds(10,10,900,720);
        //窗口大小不变
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件，游戏可以关闭
        f.add(new GamePanel());
        f.setVisible(true);//窗口展示
    }
}
