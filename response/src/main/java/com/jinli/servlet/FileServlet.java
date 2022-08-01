package com.jinli.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* ctr+shirt+s -- 录屏
        * 1、要获取下载的文件路径
        * 2、下载的文件名是什么
        * 3、想办法让浏览器能够支持我们需要下载的东西
        * 4、获取下载文件的输入流
        * 5、创建缓冲区
        * 6、获取OutputStream的对象
        * 7、将FileOutputStream流写到缓冲区
        * 8、使用OutputStream将缓冲区中的数据输出到客户端
        * */

        // Q:为什么打包没有那个路径
//    ctrl+/                                    * 1、要获取下载的文件路径
        Set<String> resourcePaths = this.getServletContext().getResourcePaths("");
        String realPath = "D:\\JAVASTUDY\\JavaWeb\\response\\target\\classes\\com\\jinli\\11.jpg";
        System.out.println("Down Path: "+realPath);

//    按住alt不动，实现多行一起写，简直不要太好用了      * 2、下载的文件名是什么
        String filename = realPath.substring(realPath.lastIndexOf("//") + 1);

//    按住alt不动，实现多行一起写，简直不要太好用了      * 3、想办法让浏览器能够支持我们需要下载的东西,固定的上网搜 Content-Disposition  attachment:filename=
        resp.setHeader("Content-Disposition", "attachment; filename="+filename);

//    按住alt不动，实现多行一起写，简直不要太好用了      * 4、获取下载文件的输入流 FileInputStream(）
        //读取输入流用in
        FileInputStream in = new FileInputStream(realPath);

//    按住alt不动，实现多行一起写，简直不要太好用了      * 5、创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024]; //就是创建一个数组的类型


//    按住alt不动，实现多行一起写，简直不要太好用了      * 6、获取OutputStream的对象  getOutputStream()
        ServletOutputStream out = resp.getOutputStream();//resp = respond

//    按住alt不动，实现多行一起写，简直不要太好用了      * 7、将FileOutputStream流写到缓冲区.  * 8、使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0){
            out.write(buffer,0,len); //缓冲区名，从哪里开始到哪里
        }

        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
