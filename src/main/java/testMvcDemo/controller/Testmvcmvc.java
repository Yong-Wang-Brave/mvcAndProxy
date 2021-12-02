package testMvcDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import testMvcDemo.domain.Item;
import testMvcDemo.service.TestMvcService;

@Controller
@RequestMapping("/testMvc")
public class Testmvcmvc {

    @Autowired
    TestMvcService testMvcService;

    @RequestMapping("/showItem1/{id}")
    public String findById(@PathVariable("id")int id, Model model){
     Item item=   testMvcService.findById(id);
        model.addAttribute("item",item);
        return "item";
    }


}
