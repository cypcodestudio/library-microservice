package com.cypcode.library_microservice.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.cypcode.library_microservice.domain.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO implements Serializable{
	private Long id;
	private String title;
	private String description;
}
