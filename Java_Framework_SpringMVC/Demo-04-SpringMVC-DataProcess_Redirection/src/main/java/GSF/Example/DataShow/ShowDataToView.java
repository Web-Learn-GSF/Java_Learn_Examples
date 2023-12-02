package GSF.Example.DataShow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowDataToView {

    // 第一种：ModelAndView，参考ResultRedirection/ModelAndView

    // ModelMap
    @RequestMapping("/show_data")
    public String test1(@RequestParam("username") String name, ModelMap model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg",name);
        System.out.println(name);
        return "/jsp/hello";
    }

    // Model
    @RequestMapping("/show_data_2")
    public String test2(@RequestParam("username") String name, Model model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg",name);
        System.out.println(name);
        return "/jsp/hello";
    }
}
