package GSF.Example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//测试拦截器的控制器
@Controller
public class InterceptorController {

    @RequestMapping("/interceptor")
    @ResponseBody   // 有该注解，返回json格式数据；没有该注解，返回对应视图解析器组合路径下的资源
    public String testFunction() {
        System.out.println("执行控制器中的方法");
        return "hello";
    }
}