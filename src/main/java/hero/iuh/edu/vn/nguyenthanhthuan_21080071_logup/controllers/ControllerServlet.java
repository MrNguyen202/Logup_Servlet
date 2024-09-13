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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
