package GSF.Example.DataProcess;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data_process")
public class ProcessSubmitData {
    @RequestMapping("/same_name")
    public String test1(String name){
        System.out.println(name);
        return "/jsp/hello";
    }

    @RequestMapping("/different_name")
    public String test2(@RequestParam("username") String name){
        System.out.println(name);
        return "/jsp/hello";
    }

    @RequestMapping("/object")
    public String test3(User user){
        System.out.println(user);
        return "/jsp/hello";
    }
}
