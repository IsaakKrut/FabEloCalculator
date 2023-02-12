package com.isaakkrut.elocalculator.controllers;


import com.isaakkrut.elocalculator.dto.Request;
import com.isaakkrut.elocalculator.services.EloService;
import com.isaakkrut.elocalculator.utils.Format;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    private final EloService eloService;

    public IndexController(EloService eloService) {
        this.eloService = eloService;
    }

//    @RequestMapping({"", "/"})
//    public String homePage(Model model){
//        Request request = new Request();
//        request.setkFactor(16);
//        request.setFormat(Format.CONSTRUCTED);
//        request.setMatches("1\tKrut, Isaak (23643736)\tLi, Yuanji (96371481)\tPlayer 1 Win\t\n" +
//                "2\tKrut, Isaak (23643736)\tGroseclose, Dan (35875295)\tPlayer 1 Win\t\n" +
//                "3\tKrut, Isaak (23643736)\tMuus, Matt (33717241)\tPlayer 1 Win\t\n" +
//                "4\tKrut, Isaak (23643736)\tHenschel, Bryce (82884659)\tPlayer 1 Win\t\n" +
//                "5\tKrut, Isaak (23643736)\tMcDaniel, Travis (12467529)\tPlayer 1 Win\t\n" +
//                "6\tKrut, Isaak (23643736)\tLin, Dave (33283899)\tPlayer 2 Win\t\n" +
//                "7\tKrut, Isaak (23643736)\tAdams, James (96214336)\tPlayer 1 Win\t\n" +
//                "8\tDel Valle, Vladimir (53781666)\tKrut, Isaak (23643736)\tPlayer 1 Win\t\n" +
//                "9\tKrut, Isaak (23643736)\tJaszczur, Michael (41361832)\tPlayer 2 Win\t\n" +
//                "10\tKrut, Isaak (23643736)\tWhite, Dagan (98661172)\tPlayer 1 Win\t\n" +
//                "11\tKrut, Isaak (23643736)\tRogers, Matt (8717)\tPlayer 2 Win\t\n" +
//                "12\tKrut, Isaak (23643736)\tBalangan, Jeerod (95529274)\tPlayer 1 Win\t");
//        model.addAttribute("tournament", eloService.calculateElo(request));
//
//        return "index";
//    }

    @GetMapping({"", "/"})
    public String greetingForm(Model model) {
        model.addAttribute("request", new Request());
        return "input";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute Request request, Model model) {
        model.addAttribute("tournament", eloService.calculateElo(request));
        return "index";
    }
}
