package com.jinli.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//共享数据：之后会使用session或者request代替
public class HelloServlet extends HttpServlet {
    //HttpServletRequest   HttpServletResponse
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        this.getInitParameter(); //初始化参数
        this.getServletConfig();  //Servlet配置
        this.getServletContext() //Servlet上下文
        */
        ServletContext context = this.getServletContext();
        String name = "jinli";//数据

        //设置属性
        context.setAttribute("name","jinli");//将数据保存在一个ServletContext中
        context.setAttribute("score","99");
       // context.getAttribute("name");//通过key取

        System.out.println("hello"); //打印在控制台的
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
