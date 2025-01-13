package com.cypcode.library_microservice.domain;

import java.io.Serializable;
import java.util.List;

import com.cypcode.library_microservice.domain.dto.AuthorDTO;
import com.cypcode.library_microservice.domain.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Author")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	@JoinColumn
	@OneToMany(fetch = FetchType.LAZY)
	private List<Book> books;
}
