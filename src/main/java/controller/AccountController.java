package controller;


import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.InterfaceAccountService;

@Controller
@RequestMapping("/acc")
public class AccountController {
    @Autowired
    InterfaceAccountService interfaceAccountService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",interfaceAccountService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",interfaceAccountService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("account",interfaceAccountService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id) {
        interfaceAccountService.Delete(interfaceAccountService.findById(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Account account) {
        interfaceAccountService.edit(account);
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Account account) {
        interfaceAccountService.save(account);
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }
}