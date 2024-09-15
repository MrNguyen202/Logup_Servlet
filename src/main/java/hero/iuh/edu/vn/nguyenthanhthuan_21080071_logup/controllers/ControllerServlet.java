/*
 * @ (#) ControllerServlet.java    1.0    9/8/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.controllers;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 9/8/2024
 * @Version: 1.0
 *
 */

import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.entities.Account;
import hero.iuh.edu.vn.nguyenthanhthuan_21080071_logup.repositories.AccountRepositry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

    AccountRepositry accountRepositry = new AccountRepositry();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "login":{
                try {
                    chekLogin(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            }


        }
    }

    private void chekLogin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException, ServletException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Account account = accountRepositry.login(email, password).orElse(null);
        if(account == null){
            req.getServletContext().getRequestDispatcher("/views/dashboard.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
