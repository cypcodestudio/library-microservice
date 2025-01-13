package com.cypcode.library_microservice.domain.dto;

import java.util.List;

import com.cypcode.library_microservice.domain.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO implements Serializable{
	private Long id;
	private String name;
	private String email;
	private List<BookDTO> books;
}
