//package hogosya;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.CreditInfo;
//import bean.Product;
//
//@WebServlet("/confirmOrder")
//public class ConfirmOrderServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        HttpSession session = req.getSession();
//
//        // セッションから選択した商品を取得
//        List<Product> selectedProducts = (List<Product>) session.getAttribute("selectedProducts");
//
//        // クレジットカード情報を取得
//        String cardNumber = req.getParameter("cardNumber");
//        String expiryMonth = req.getParameter("expiryMonth");
//        String expiryYear = req.getParameter("expiryYear");
//        String cardName = req.getParameter("cardName");
//        String securityCode = req.getParameter("securityCode");
//
//        // クレジットカード情報をオブジェクトにセット
//        CreditInfo creditInfo = new CreditInfo();
//        creditInfo.setCardNumber(cardNumber);
//        creditInfo.setExpiryMonth(expiryMonth);
//        creditInfo.setExpiryYear(expiryYear);
//        creditInfo.setCardName(cardName);
//        creditInfo.setSecurityCode(securityCode);
//
//        // セッションに格納
//        session.setAttribute("creditInfo", creditInfo);
//
//        // 購入確認ページへフォワード
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/hogosya/buyConf.jsp");
//        dispatcher.forward(req, resp);
//    }
//}
