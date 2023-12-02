package GSF.Example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/controller")
public class HelloController_Annotation {

    //真实访问地址 : 项目名/controller/hello
    @RequestMapping("/annotation")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC, Controller_Annotation");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}