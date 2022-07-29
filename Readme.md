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
       