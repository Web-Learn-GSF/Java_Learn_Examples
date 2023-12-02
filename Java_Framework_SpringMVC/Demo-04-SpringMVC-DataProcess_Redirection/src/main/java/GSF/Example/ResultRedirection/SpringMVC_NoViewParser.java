package GSF.Example.ResultRedirection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 请求前需要先注释掉springmvc-servlet.xml的视图解析器

@Controller
public class SpringMVC_NoViewParser {

    @RequestMapping("/springMvc_redirection/test1")
    public String test1() {
        // 转发
        return "/index_1.jsp";
    }

    @RequestMapping("/springMvc_redirection/test2")
    public String test2() {
        // 转发
        //return "forward:/index.jsp";
        //return "forward:/index_1.jsp";
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/springMvc_redirection/test3")
    public String test3() {
        // 重定向：不让定向到受保护的视图资源内
        //return "redirect:/index.jsp";
        return "redirect:/WEB-INF/jsp/hello.jsp";
    }
}
