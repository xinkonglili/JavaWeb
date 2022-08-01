1、实现servlet包下面的类（继承extends HelloServlet），然后去web.xml中进行配置
```aidl
<!--404-->
    <servlet>
        <servlet-name>error</servlet-name> //name 要一致
        <servlet-class>com.jinli.servlet.ErrorServlet</servlet-class>//类的位置
    </servlet>
    
    <servlet-mapping>
        <servlet-name>error</servlet-name>
        <url-pattern>/error</url-pattern>//访问的url路径
    </servlet-mapping>
```

2、指定了固有的映射路径的优先级最高，指定 > 通配符*

3、Deployment 的jar包只有一个，重新构建项目的时候，要把前一个jar包删除

4、如果Deployment中无法显示jar图标，刷新maven的标志

5、servletContext：共享数据

6、更改web.xml中的配置


``` 
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">
</web-app>
```
7、下载问件的步骤
```aidl
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
```
       