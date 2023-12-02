package GSF.Example.Restful;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Restful_method {
    //@RequestMapping(value = "/restful_method/{var1}/{var2}", method = {RequestMethod.POST})
    @RequestMapping(value = "/restful_method/{var1}/{var2}")
    @GetMapping
    public String calculate(@PathVariable int var1, @PathVariable int var2, Model model){
        int result = var1 + var2;
        model.addAttribute("msg", "求和结果：" + result);
        return "hello";
    }
}
