package com.java.snack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener,ActionListener {
//画板
    int length;//长度
    int[] snakeX=new int[600];//蛇的坐标
    int[] snakeY=new int[500];
    String fx;//方向
    int foodx;
    int foody;
    int score;
    Random ran=new Random();
    boolean isStart,isFile;
    //
    Timer time=new Timer(100,  this);
    //初始化
    public void init(){
        length=3;
        snakeX[0]=100;snakeY[0]=100;//头部坐标
        snakeX[1]=75;snakeY[1]=100;//身体
        snakeX[2]=50;snakeY[2]=100;
        fx="R";
        isStart=false;
        isFile=false;
        foodx=25+25*ran.nextInt(34);
        foody=75+25*ran.nextInt(24);
        score=0;
    }
    public GamePanel(){
        init();
        //获取监听
        this.setFocusable(true);
        this.addKeyListener(this);
        time.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.white);

        //绘制广告栏
        Data.header.paintIcon(this,g,25,11);
        //绘制游戏区域
        g.fillRect(25,75,850,600);

        //动态snake
        if(fx.equals("R")) {
            Data.rightheader.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (fx.equals("L")){
            Data.leftheader.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (fx.equals("U")){
            Data.upheader.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (fx.equals("D")){
            Data.downheader.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i=1;i<length;i++){
            Data.bodyer.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        g.setColor(Color.WHITE);//画笔颜色
        g.setFont(new Font("微软雅黑",Font.BOLD,18));//笔设置
        g.drawString("snack长度:"+length,750,35);
        g.drawString("分数:"+score,750,50);
        Data.fooder.paintIcon(this,g,foodx,foody);
        //游戏提示
        if(isStart==false){
            g.setColor(Color.white);//画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//笔设置
            g.drawString("按下空格开始游戏",300,300);
        }
        //失败判断
        if (isFile){
            g.setColor(Color.RED);//画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//笔设置
            g.drawString("游戏失败，按下空格开始",300,300);
        }

    }
    //键盘监听
    @Override
    public void keyTyped(KeyEvent e) {
        //按下弹起
    }

    @Override
    public void keyPressed(KeyEvent e) {
    //按下
        //监听按键
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFile==true){
                isFile=false;
                init();
            }else{
                isStart=!isStart;

            }
            repaint();//刷新

        }
        if(keyCode==KeyEvent.VK_LEFT){
            fx="L";
        }
        if(keyCode==KeyEvent.VK_RIGHT){
            fx="R";
        }
        if(keyCode==KeyEvent.VK_UP){
            fx="U";
        }
        if(keyCode==KeyEvent.VK_DOWN){
            fx="D";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    //谈起
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //游戏开始状态 没100毫秒执行监听一次
        if(isStart && isFile==false){
            for (int i=length-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //头移动
            if(fx.equals("R")){
                snakeX[0]=snakeX[0]+25;//头部移动
                if(snakeX[0]>850) snakeX[0]=25;
            }else if (fx.equals("L")){
                snakeX[0]=snakeX[0]-25;//头部移动
                if(snakeX[0]<25) snakeX[0]=850;
            }else if (fx.equals("U")){
                snakeY[0]=snakeY[0]-25;//头部移动
                if(snakeY[0]<75) snakeY[0]=650;
            }
            else if (fx.equals("D")){
                snakeY[0]=snakeY[0]+25;//头部移动
                if(snakeY[0]>650) snakeY[0]=75;
            }
            if(snakeX[0]==foodx && snakeY[0]==foody){
                length++;
                score++;
                foodx=25+25*ran.nextInt(34);
                foody=75+25*ran.nextInt(24);
            }
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFile=true;
                }
            }


            repaint();
        }
        time.start();//让时间动起来
    }
}
