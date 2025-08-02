package controller;

import dao.CartDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.CartItem;
import model.Product;

public class UpdateProductFromCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int productId;
        int newQty;
        try {
            productId = Integer.parseInt(request.getParameter("productId"));
            newQty    = Integer.parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/cart.jsp?msg=Tham+so+khong+hop+le");
            return;
        }
        if (newQty < 0) newQty = 0; // quy ước: 0 => xoá dòng

        // Tìm sản phẩm để lấy tên/giá (và có thể kiểm tra tồn kho)
        Product p = ProductDAO.getInstance().getProductById(productId);
        if (p == null) {
            response.sendRedirect(request.getContextPath() + "/cart.jsp?msg=San+pham+khong+ton+tai");
            return;
        }

        // (Tuỳ chọn) Ràng buộc tồn kho
        // if (newQty > p.getStockQuantity()) newQty = p.getStockQuantity();

        HttpSession session = request.getSession();
        CartDAO cart = (CartDAO) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartDAO();
            session.setAttribute("cart", cart);
        }

        int current = cart.getQuantityOf(productId);
        int delta = newQty - current;

        if (current == 0) {
            // chưa có trong giỏ
            if (newQty > 0) {
                cart.addItem(new CartItem(p.getId(), p.getName(), newQty, p.getPrice()));
            } // newQty == 0 => không làm gì
        } else {
            // đã có trong giỏ -> bù phần chênh lệch
            if (delta > 0) {
                cart.increaseQuantity(productId, delta);   // TĂNG đúng delta
            } else if (delta < 0) {
                cart.decreaseQuantity(productId, -delta);  // GIẢM đúng -delta
            } // delta == 0 => không thay đổi
        }

        // Nếu bạn dùng badge trong session:
        session.setAttribute("quantitycart", cart.getTotalQuantity());

        response.sendRedirect(request.getContextPath() + "/cart.jsp?msg=updated");
    }
}
