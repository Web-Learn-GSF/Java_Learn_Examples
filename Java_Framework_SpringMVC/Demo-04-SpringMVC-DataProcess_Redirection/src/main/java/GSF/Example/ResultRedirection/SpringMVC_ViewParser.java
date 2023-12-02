package GSF.Example.ResultRedirection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class SpringMVC_ViewParser {
    @RequestMapping("/springMvc_redirection_VP/test1")
    public String test1() throws IOException {
        // 转发：自动借助视图解析器补充前缀和后缀
        //return "index_1";     // 不行
        //return "/index_2";    // 行
        return "/jsp/hello";    // 行
    }

    @RequestMapping("/springMvc_redirection_VP/test2")
    public String test2() throws IOException {
        // 重定向：不需要视图解析器，写全路径
        return "redirect:/Result_Redirection/test2.jsp";
    }
}
