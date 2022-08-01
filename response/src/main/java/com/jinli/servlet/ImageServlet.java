package com.jinli.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

//浏览器实时刷新，右键下载图片
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh", "2");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = (Graphics2D)image.getGraphics();//笔

        //设置图片的背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.ITALIC,20));
        g.drawString(makeNum(),2,20);//从哪个点开始化

        //告诉浏览器用图片的方式打开文件
        resp.setContentType("image/jpeg");

        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }


    //生成随机数
    private String makeNum(){
        Random random = new Random();
        //nextInt判断输入的是不是整数
        String num = random.nextInt(9999999)+ " "; //9999999代表7位数，转成string类型的
        StringBuffer sb = new StringBuffer();
        //快捷输入fori
        for (int i = 0; i < 7-num.length() ; i++) { //万一随机数生成的不是7位，后面用0来补充
            sb.append("0");
        }

        num = sb.toString()+num;
        return num;//返回随机数
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
