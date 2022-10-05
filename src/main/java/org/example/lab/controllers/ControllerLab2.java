package org.example.lab.controllers;

import org.example.lab.dao.LinksDAO;
import org.example.lab.models.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource("classpath:password.properties")
@RequestMapping("/website")
public class ControllerLab2 {
    private final LinksDAO linksDAO;
    private final Environment env;
    @Autowired
    public ControllerLab2(LinksDAO linksDAO, Environment env) {
        this.linksDAO = linksDAO;
        this.env = env;
    }

    @GetMapping
    public String homePage() {
        return "home/homePage";
    }

    @GetMapping("/admin-password-page")
    public String administrativePasswordPage() {
        return "admin/adminPasswordPage";
    }

    @GetMapping("/admin-page")
    public String adminPage(HttpServletRequest request) {
        if (request.getParameter("pass").equals(env.getRequiredProperty("password"))) {
            return "admin/adminPage";
        }
        return "admin/adminPasswordPage";
    }

    @GetMapping("/user-page")
    public String userPage() {
        return "user/userPage";
    }

    @GetMapping("/author")
    public String author(){
        return "info/aboutAuthor";
    }

    @GetMapping("/site")
    public String site(){
        return "info/aboutWebSite";
    }

    @GetMapping("/list/links")
    public String showAllLinks(Model model){
        model.addAttribute("links", linksDAO.showAllLinks());
        return "link/linksPage";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        linksDAO.editSessionCounter(id);
        model.addAttribute("link", linksDAO.show(id));
        return "link/linkPage";
    }

    @GetMapping("/statistic")
    public String showAllLinksAndSessionCounter(Model model){
        model.addAttribute("links", linksDAO.showAllLinks());
        return "link/linkStatisticPage";
    }

    @GetMapping("/addLink")
    public String addLink(@ModelAttribute("link") Link link){
        return "link/addLink";
    }

    @PostMapping
    public String create (@ModelAttribute("link") Link link){
        linksDAO.save(link);
        return "redirect:website/admin-page?pass=" + env.getRequiredProperty("password");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        linksDAO.delete(id);
        return "redirect:/website/statistic";
    }

}
