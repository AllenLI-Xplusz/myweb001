package com.xplusz.mercury.servlets;

import com.xplusz.mercury.services.*;

import java.io.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;



public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");//设置服务器响应的内容格式
       // response.setCharacterEncoding("gb2312");//设置服务器响应的字符编码格式。
        DButil ab = new DButil();
        try {
            PrintWriter pw = response.getWriter();
           // String tep=new String(request.getParameter("id").getBytes("ISO-8859-1"));
            String name = new String(request.getParameter("name").getBytes("ISO-8859-1"));//能显示中文
           // int id=Integer.valueOf(tep);


          if(  ab.addstudent(name)==true)
          {
              request.getRequestDispatcher("succ.jsp?info='add succ'").forward(request, response);
          }




        } catch (Exception e) {
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);///调用doGet方法
    }
}
