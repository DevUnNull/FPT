import java.io.IOException;
import java.util.regex.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

public class RegexTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String input = request.getParameter("input");
        String symbol = request.getParameter("regexSymbol");

        String result = "";

        if (symbol.equals("\\d")) {
            if (input.matches("\\d")) {
                result = "✅ Bạn đã điền đúng định dạng của " + symbol;
            } else {
                result = "❌ Bạn cần nhập 1 chữ số (0-9) cho " + symbol;
            }
        } else if (symbol.equals("\\d+")) {
            if (input.matches("\\d+")) {
                result = "✅ Bạn đã điền đúng định dạng của " + symbol;
            } else {
                result = "❌ Bạn cần nhập 1 hoặc nhiều chữ số (ví dụ: 123)";
            }
        }
        else if (symbol.equals("\\D")) {
            if (input.matches("\\D")) {
                result = "✅ Hợp lệ: 1 ký tự KHÔNG PHẢI là chữ số";
            } else {
                result = "❌ Chuỗi phải KHÔNG PHẢI là chữ số (ví dụ: a, #, _)";
        }
        }else if (symbol.equals("\\w")) {
            if (input.matches("\\w")) {
                result = "✅ Hợp lệ: 1 ký tự chữ hoặc số hoặc gạch dưới";
            } else {
                result = "❌ Không hợp lệ cho \\w";
            }
        } else if (symbol.equals("\\w+")) {
            if (input.matches("\\w+")) {
                result = "✅ Hợp lệ: nhiều ký tự chữ hoặc số hoặc gạch dưới";
            } else {
                result = "❌ Không hợp lệ cho \\w+";
            }
        } else if (symbol.equals("Gmail")) {
            if (input.matches("\\w+@gmail.com")) {
                result = "✅ Hợp lệ: Đã nhập đúng Gmail";
            } else {
                result = "❌ Không hợp lệ cho Gmail";
            }
        } else if (symbol.equals("SDT")) {
            if (input.matches("^(03|05|07|08|09)\\d{8}$")) {
                result = "✅ Hợp lệ: Đã nhập đúng SDT";
            } else {
                result = "❌ Không hợp lệ cho SDT";
            }
        } else {
            // fallback xử lý các regex khác
            try {
                Pattern pattern = Pattern.compile(symbol);
                if (input.matches(symbol)) {
                    result = "✅ Chuỗi KHỚP với biểu thức: " + symbol;
                } else {
                    result = "❌ Chuỗi KHÔNG KHỚP với biểu thức: " + symbol;
                }
            } catch (PatternSyntaxException e) {
                result = "⚠️ Lỗi cú pháp Regex: " + e.getMessage();
            }
        }

        // Đưa kết quả ra lại JSP
        request.setAttribute("input", input);
        request.setAttribute("regex", symbol);
        request.setAttribute("result", result);

        request.getRequestDispatcher("regex_result.jsp").forward(request, response);
    }
}
