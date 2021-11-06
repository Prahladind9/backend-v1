package com.spring.professional;

import com.spring.professional.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class SpringController {
    @Autowired
    private SpringBean1 springBean1;
    @Autowired
    private SpringBean2 springBean2;
    @Autowired
    private SpringBean3 springBean3;
    @Autowired
    private SpringBean4 springBean4;
    @Autowired
    private SpringBean5 springBean5;

    @RequestMapping
    @ResponseBody
    public String index(){
        return "<pre>"+
                springBean1 + " - Singleton\n"+
                springBean2 + " - Prototype\n"+
                springBean3 + " - Request\n"+
                springBean4 + " - Session\n"+
                springBean5 + " - Application\n"+
                "</pre>";
    }
}
