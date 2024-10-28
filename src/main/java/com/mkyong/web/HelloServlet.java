package com.mkyong.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.xdevapi.PreparableStatement;

import jakarta.servlet.RequestDispatcher;
// import jakarta.servlet.ServletContext;
//https://www.convertcsv.com/csv-to-json.htm
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
// https://th.bing.com/th/id/R.c986f082a019ada70523b28f39ef9afe?rik=8EVTDVPyjjw6Ow&riu=http%3a%2f%2fj2eetutorials.50webs.com%2fservlet-class-hierarchy.JPG&ehk=EO3EXzZvsO3C8gE8XXFWdW6nhRLbCOixpzuogMijYVc%3d&risl=&pid=ImgRaw&r=0
//get,put,post,patch
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
  
    // req from browser this method process the response
    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // super.doGet(req, resp);
        // to send the data to jsp => java->jsp
        // https://splessons.com/lesson/http-servlets/
        // List<String> arr=List.of("Banana", "Apple", "Mango", "Orange");
        // List<Integer> ar=List.of(10,20,30);
        // arr.forEach(System.out::println);
        // req.setAttribute("fruits", arr);
        // req.setAttribute("numerics", ar);

        // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        // RequestDispatcher rd1 = req.getRequestDispatcher("index.jsp");
        // rd.include(req, resp);

    //     Connection con;
    //     try {
    //         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
    //         PreparedStatement pst = con.prepareStatement("select * from bus_details");

    //         ResultSet rs = pst.executeQuery();

    //         List<Bus> li = new ArrayList<>();
    //         while (rs.next()) {
    //             Bus b = new Bus();
    //             b.setAvaildate(rs.getDate(1));
    //             b.setBusNo(rs.getInt(2));
    //             b.setBusName(rs.getString(3));
    //             b.setAvailableSeats(rs.getInt(4));
    //             b.setCustome_name(rs.getString(5));
    //             li.add(b);

    //         }
    //         // li.forEach(System.out::println);
    //         req.setAttribute("Details", li);
    //         RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    //         req.setAttribute("Details", li);
    //         RequestDispatcher rd1 = req.getRequestDispatcher("/index.jsp");
    //         rd.forward(req, resp);
           
    //     } catch (SQLException e) {

    //         e.printStackTrace();
    //     }

        

    // }
    // https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiShNV0bK7Jt9D53ykevnog-hMIuBJXI-1i2MlRH9KFMWq2Xdpg3_nyEACQwPoMOWrmH48bZJv-C-1nR_GhZd5qqGk3Kii2oI4_uz0H0ouWQtsTm2cy37TotttR95on5o8fdbgM48clKnw/w611-h347/forward+method+of+RequestDispatcher+and+Servlet.jpg

    // res.setContentType("text/html");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String availableDate
         = request.getParameter("availdate");
        String busNumber = request.getParameter("busnumber");
        String busName = request.getParameter("busName");
        String availableSeats = request.getParameter("AvailSeats");
        String customerName = request.getParameter("customerName");

        if (availableDate == null || busNumber == null || busName == null || availableSeats == null
                || customerName == null || availableDate.trim().isEmpty() || busNumber.trim().isEmpty()
                || busName.trim().isEmpty() || availableSeats.trim().isEmpty() || customerName.trim().isEmpty()) {
            request.setAttribute("error", "Error occurred or u may miss the data to be filled");

            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        // Insert data into the database
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "");
            PreparedStatement pst = con.prepareStatement("insert into bus_details values(?,?,?,?,?)");
            pst.setDate(1, java.sql.Date.valueOf(availableDate));
            pst.setInt(2,Integer.parseInt(busNumber));
            pst.setString(3, busName);
            pst.setInt(4, Integer.parseInt(availableSeats));
            pst.setString(5, customerName);
            pst.executeUpdate();

        } catch (SQLException e) {

            request.setAttribute("error", "error occurred");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("success.jsp");

    }

    
}
