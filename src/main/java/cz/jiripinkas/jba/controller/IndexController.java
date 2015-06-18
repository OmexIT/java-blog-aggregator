package cz.jiripinkas.jba.controller;

import cz.jiripinkas.jba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by omexic on 6/13/2015.
 */
@Controller
public class IndexController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "index";
    }
}
