package GSF.Example.ErrorCode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorCode_Show {
    @RequestMapping("/error_code")
    public String test(Model model, String name){
        // 并没有出现乱码，等以后碰到乱码了，再说吧

        model.addAttribute("msg",name); //获取表单提交的值
        return "/jsp/hello"; //跳转到test页面显示输入的值
    }
}
