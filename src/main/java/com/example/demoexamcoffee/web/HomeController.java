package com.example.demoexamcoffee.web;

import com.example.demoexamcoffee.model.view.OrderViewModel;
import com.example.demoexamcoffee.sec.CurrentUser;
import com.example.demoexamcoffee.service.OrderService;
import com.example.demoexamcoffee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;

    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId()==null){
        return "index";
        }

        List<OrderViewModel> order = orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders",order);
        model.addAttribute("totalTime",order.stream().map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(null));

        model.addAttribute("users",userService.findAllUserAndCountOfOrderByCountDesc());

        return "home";


    }
}
