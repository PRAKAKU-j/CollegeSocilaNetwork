package com.capgemini.controller;

import com.capgemini.dto.MessageDTO;
import com.capgemini.dto.UserDTO;
import com.capgemini.services.MessagesService;
import com.capgemini.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static com.capgemini.utils.ServerUtils.getUserFromSession;

@Controller
@RequestMapping("/api")
public class MessagesController {

    private MessagesService messagesService;
    private UserService userService;


    private void addConversationToModel(Long companionId, HttpServletRequest request, Model model) {
        UserDTO user = getUserFromSession(request);
        UserDTO companion = userService.getUserById(companionId);
        List<MessageDTO> messages = messagesService.findConversation(user.getId(), companionId);
        model.addAttribute("messages", messages);
        model.addAttribute("companion", companion);
    }

    @GetMapping("/messages")
    public String getMessages(HttpServletRequest request, Model model) {
        UserDTO user = getUserFromSession(request);
        Collection<MessageDTO> recentMessages = messagesService.findAllRecentMessages(user.getId());
        model.addAttribute("recentMessages", recentMessages);
        return "messages";
    }

    @GetMapping("/conversation/{companionId}")
    public String getConversation(@PathVariable Long companionId, HttpServletRequest request, Model model) {
        addConversationToModel(companionId, request, model);
        model.addAttribute("newMessage", new MessageDTO());
        return "conversation";
    }

    @PostMapping("/conversation/{companionId}")
    public String postMessage(@PathVariable Long companionId,
                              @Valid @ModelAttribute("newMessage") MessageDTO messageDTO, BindingResult bindingResult,
                              HttpServletRequest request, Model model) {
        if(bindingResult.hasErrors()) {
            addConversationToModel(companionId, request, model);
            return "conversation";
        }
        UserDTO user = getUserFromSession(request);
        UserDTO companion = userService.getUserById(companionId);
        messageDTO.setSender(user);
        messageDTO.setReceiver(companion);
        messageDTO.setTime(LocalDateTime.now());
        messagesService.postMessage(messageDTO);
        return "redirect:/user/conversation/" + messageDTO.getReceiver().getId();
    }
}
