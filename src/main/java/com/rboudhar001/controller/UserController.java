package com.rboudhar001.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rboudhar001.model.User;
import com.rboudhar001.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService mUserService;

	@GetMapping("")
	public String list(Model model) {

		List<User> list = mUserService.findAll();

		model.addAttribute("users", list);
		return "user/list";
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable long id, Model model) {
		
		Optional<User> oUser = mUserService.findById(id);
		List<User> friends = mUserService.findFriends(id);
		List<User> suggestedFriends = mUserService.findSuggestedFriends(id);
		
		model.addAttribute("user", oUser.get());
		model.addAttribute("friends", friends);
		model.addAttribute("suggestedFriends", suggestedFriends);
		
		return "user/view";
	}

	@GetMapping("/add")
	public String addGET(Model model) {

		model.addAttribute("user", new User());
		return "user/add";
	}

	@PostMapping("/add")
	public String addPOST(@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/add";
		}

		mUserService.save(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/update")
	public String updateGET(@PathVariable long id, Model model) {

		User user = mUserService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("user", user);
		return "user/update";
	}

	@PostMapping("/{id}/update")
	public String updatePOST(@PathVariable long id, @Valid User user, BindingResult result, Model model) {
		
		user.setId(id);
		if (result.hasErrors()) {
			return "user/update";
		}
		
		mUserService.save(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable long id, Model model) {

		// Security
		// ...

		mUserService.deleteById(id);
		return "redirect:/users";
	}
}
