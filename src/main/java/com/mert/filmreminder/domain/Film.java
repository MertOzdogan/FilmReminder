package com.mert.filmreminder.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long length;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "films_user_watched", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private Set<User> usersWatched = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "films_user_will_watch", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private Set<User> usersWillWatch = new HashSet<User>();
	@Lob
	private String description;
}
