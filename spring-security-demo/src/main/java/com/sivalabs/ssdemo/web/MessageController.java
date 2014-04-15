package com.sivalabs.ssdemo.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.ssdemo.entities.Message;
import com.sivalabs.ssdemo.entities.User;
import com.sivalabs.ssdemo.services.EmailService;
import com.sivalabs.ssdemo.services.MessageService;
import com.sivalabs.ssdemo.services.UserService;
import com.sivalabs.ssdemo.web.model.AjaxResponse;
import com.sivalabs.ssdemo.web.model.ContactForm;

/**
 * @author Siva
 * 
 */
@Controller
public class MessageController extends BaseController
{
	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("messages", messageService.getAllMessages());
		return "welcome";
	}
	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	public String saveMessage(Message msg, HttpSession session)
	{
		try {
			//msg.setPostedBy(getCurrentUser());
			msg.setPostedBy(new User(1));
			messageService.createMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:welcome";
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Message> getMessages()
	{

		List<Message> messages = messageService.getAllMessages();
		return messages;
	}
	
	@RequestMapping(value = "/contactUs", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public AjaxResponse contactUs(@RequestBody @Validated ContactForm contactForm, BindingResult result) {
		AjaxResponse response = new AjaxResponse();
		if(result.hasErrors())
		{
			response.setStatus(false);
			String errors = "";
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				//response.addError(fieldError.getDefaultMessage());
				errors += fieldError.getDefaultMessage()+"\n";
			}
			response.setMessage(errors);
			return response;
		}
		//System.out.println(contactForm);
		try {
			emailService.sendMail(contactForm.getEmail(), 
									contactForm.getTitle(),
									contactForm.getMessage());
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
