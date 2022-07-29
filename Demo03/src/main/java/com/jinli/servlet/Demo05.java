package com.jinli.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件
public class Demo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //相对于target的路径
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

        Properties prop = new Properties();
        prop.load(in);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String jin = prop.getProperty("jin");
        String score = prop.getProperty("score");

        //name:root 251767 "student" 99 ---配置文件里面的信息
        resp.getWriter().println("name:"+ username+ " "+ password +" " + jin +" "+ score+ " ");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
