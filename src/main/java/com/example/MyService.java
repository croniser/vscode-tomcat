package com.example;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyService extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("I come from a service");
    }

}
