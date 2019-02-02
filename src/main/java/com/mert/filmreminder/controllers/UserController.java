package com.mert.filmreminder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mert.filmreminder.services.FilmService;
import com.mert.filmreminder.services.UserService;

@Controller
public class UserController {

	@Autowired
	private final UserService userService;
	@Autowired
	private final FilmService filmService;

	public UserController(final UserService userService, final FilmService filmService) {
		this.userService = userService;
		this.filmService = filmService;
	}

	@GetMapping
	@RequestMapping("film/{id}/show")
	private String showById(@PathVariable final String id, final Model model) {
		model.addAttribute("film", this.filmService.getFilmById(Long.valueOf(id)));
		return "film/show";
	}

}
