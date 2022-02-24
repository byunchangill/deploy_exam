package com.koreait.deploy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAO : Data Access Object
public class BoardDAO {
    public static int insBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title, ctnt, writer) " +
                "VALUES (?, ?, ?)";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setString(3, param.getWriter());
            return ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        finally { DbUtils.close(con, ps); }
        return 0;
    }

    public static List<BoardVO> selBoardList() {
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT iboard, title, writer, rdt FROM t_board " +
                    " ORDER BY iboard DESC ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) { //true, false
                int iboard = rs.getInt("iboard");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String rdt = rs.getString("rdt");
                BoardVO vo = new BoardVO();
                vo.setIboard(iboard);
                vo.setTitle(title);
                vo.setWriter(writer);
                vo.setRdt(rdt);
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;
    }

    public static BoardVO selBoardDetail(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_board WHERE iboard = ?";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            rs = ps.executeQuery();
            if(rs.next()){
                String title = rs.getString("title");
                String ctnt = rs.getString("ctnt");
                String writer = rs.getString("writer");
                String rdt = rs.getString("rdt");

                BoardVO vo = new BoardVO();
                vo.setIboard(param.getIboard());
                vo.setTitle(title);
                vo.setCtnt(ctnt);
                vo.setWriter(writer);
                vo.setRdt(rdt);
                return vo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return null;
    }

    public static int updBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE t_board SET title = ?, ctnt = ?, writer = ? " +
                    " WHERE iboard = ? ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setString(3, param.getWriter());
            ps.setInt(4, param.getIboard());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { DbUtils.close(con, ps); }
        return 0;
    }

    public static int delBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM t_board WHERE iboard = ?";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { DbUtils.close(con, ps); }
        return 0;
    }
}
