package GSF.Example.Restful;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Restful {
    @RequestMapping("/restful/{var1}/{var2}")
    public String calculate(@PathVariable int var1, @PathVariable int var2, Model model){
        int result = var1 + var2;
        model.addAttribute("msg", "求和结果：" + result);
        return "hello";
    }

}
