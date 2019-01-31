package com.mert.filmreminder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mert.filmreminder.services.FilmService;
import com.mert.filmreminder.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	private final UserService userService;
	private final FilmService filmService;

	public IndexController(final UserService userService, final FilmService filmService) {
		this.userService = userService;
		this.filmService = filmService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(final Model model) {
		model.addAttribute("films", this.filmService.getFilms());
		model.addAttribute("filmsToBeWatched", this.filmService.getFilms());

		return "index";
	}

}
