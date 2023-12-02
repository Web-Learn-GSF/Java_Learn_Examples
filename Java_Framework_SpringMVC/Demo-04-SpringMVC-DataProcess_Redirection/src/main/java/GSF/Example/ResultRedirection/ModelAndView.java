package GSF.Example.ResultRedirection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.Controller;

public class ModelAndView implements Controller {
    @Override
    public org.springframework.web.servlet.ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        org.springframework.web.servlet.ModelAndView mv = new org.springframework.web.servlet.ModelAndView();
        mv.addObject("msg", "hello, Result Redirection, ModelAndView");
        mv.setViewName("hello");
        return mv;
    }
}
