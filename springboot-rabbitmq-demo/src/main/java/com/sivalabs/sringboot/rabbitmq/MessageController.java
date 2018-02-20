package com.sivalabs.sringboot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MessageController {
    private final OrderMessageSender orderMessageSender;

    @Autowired
    public MessageController(OrderMessageSender orderMessageSender) {
        this.orderMessageSender = orderMessageSender;
    }

    @PostMapping("/sendMsg")
    public String handleMessage(Order order, RedirectAttributes redirectAttributes) {
        orderMessageSender.sendOrder(order);
        redirectAttributes.addFlashAttribute("message", "Order message sent successfully");
        return "redirect:/";
    }
}
