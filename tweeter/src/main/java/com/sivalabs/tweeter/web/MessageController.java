package com.sivalabs.tweeter.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.tweeter.entities.Message;
import com.sivalabs.tweeter.services.MessageService;
import com.sivalabs.tweeter.services.UserService;
import com.sivalabs.tweeter.web.model.AjaxResponse;
import com.sivalabs.tweeter.web.model.AjaxResponseBuilder;

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

	@RequestMapping(value = "/messages", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public AjaxResponse saveMessage(@RequestBody Message msg, HttpSession session)
	{
		AjaxResponseBuilder builder = new AjaxResponseBuilder();
		try {
			msg.setPostedBy(this.getLoginUser(session));
			messageService.createMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return builder.build();
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Message> getMessages()
	{

		List<Message> messages = messageService.getAllMessages();
		return messages;
	}
}
