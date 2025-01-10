package org.jsp.oauth_example;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("username", principal.getAttribute("login"));
        String pic=principal.getAttribute("picture");
        if(pic!=null && !pic.isEmpty())
        model.addAttribute("pic",pic);
        else
        model.addAttribute("pic", principal.getAttribute("avatar_url"));
        return "home"; 
    }
}
