package com.bounce.submore.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }


}
