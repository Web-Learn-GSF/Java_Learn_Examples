package GSF.Example.ResultRedirection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ServletAPI {

    @RequestMapping("servlet_redirection/test1")
    public void test1(HttpServletRequest req, HttpServletResponse rsp) throws IOException {
        // 输出
        rsp.getWriter().println("hello, Result Redirection, ServletAPI: rsp.getWriter().println");
    }

    @RequestMapping("servlet_redirection/test2")
    // 重定向：禁止指向受保护的视图资源
    public void test2(HttpServletRequest req, HttpServletResponse rsp) throws IOException {
        rsp.sendRedirect("/Result_Redirection/test2.jsp");
    }

    @RequestMapping("servlet_redirection/test3")
    public void test3(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        // 请求转发：可以指向受保护的视图资源
        req.setAttribute("msg", "hello, Result Redirection, ServletAPI: req.setAttribute, req.getRequestDispatcher");
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, rsp);
    }
}
