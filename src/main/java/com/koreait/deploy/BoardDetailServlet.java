package com.koreait.deploy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        //쿼리스트링
        String strIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(strIboard);

        BoardVO param = new BoardVO();
        param.setIboard(iboard);

        BoardVO vo = BoardDAO.selBoardDetail(param);
        req.setAttribute("data", vo);

        String jsp = "/WEB-INF/jsp/detail.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }
}
