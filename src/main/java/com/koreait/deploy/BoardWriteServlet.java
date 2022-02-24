package com.koreait.deploy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsp = "/WEB-INF/jsp/write.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(jsp);
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        String writer = req.getParameter("writer");

        System.out.println("title : " + title);
        System.out.println("ctnt : " + ctnt);
        System.out.println("writer : " + writer);

        BoardVO param = new BoardVO();
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(writer);

        int result = BoardDAO.insBoard(param);

        res.sendRedirect("/list");
    }
}