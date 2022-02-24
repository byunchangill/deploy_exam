package com.koreait.deploy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(strIboard);

        BoardVO param = new BoardVO();
        param.setIboard(iboard);

        BoardVO vo = BoardDAO.selBoardDetail(param);
        req.setAttribute("data", vo);

        String jsp = "/WEB-INF/jsp/mod.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(strIboard);
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        String writer = req.getParameter("writer");

        System.out.println("title : " + title);
        System.out.println("ctnt : " + ctnt);
        System.out.println("writer : " + writer);

        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(writer);

        int result = BoardDAO.updBoard(param);

        res.sendRedirect("/detail?iboard=" + strIboard);
    }
}