package com.mert.filmreminder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mert.filmreminder.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	private final UserRepository userRepository;

	public IndexController(final UserRepository userService) {
		this.userRepository = userService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(final Model model) {
		System.err.println(this.userRepository.findByUsername("Mert"));
		return "";
	}

}
