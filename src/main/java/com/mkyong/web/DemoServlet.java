package com.mkyong.web;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class DemoServlet extends HttpServlet {  

 

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   ServletContext context = getServletContext();
   context.setAttribute("busName", "Rajam");
   context.setAttribute("companyName", "Rajam Transports");
   context.setAttribute("yearFounded", "1233");
   context.setAttribute("motto", "Travel in cheap");

   req.getRequestDispatcher("busProfile.jsp").forward(req, resp);
}

}  
