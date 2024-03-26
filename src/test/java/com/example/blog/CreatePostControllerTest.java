package com.example.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.blog.application.usecase.dto.PostInputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class CreatePostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Description("It should create a post via API")
	public void createPostViaAPI() throws JsonProcessingException, Exception {
		PostInputDTO inputForCreatePost = new PostInputDTO("The Enigmatic Journey of Cosmic Whispers",
				"Embark on a mysterious exploration through the celestial realms where whispers from the cosmos reveal secrets of the unknown. Join this enigmatic journey of discovery and transcendence",
				LocalDateTime.parse("2024-02-02T17:06:30"));
		MvcResult returnOfCallCreatePost = this.mockMvc
				.perform(post("/api/v1/post/createPost").header("Content-Type", "application/json")
						.content(this.objectMapper.writeValueAsBytes(inputForCreatePost)))
				.andExpect(status().isOk()).andReturn();
		String outputForCreatePost = returnOfCallCreatePost.getResponse().getContentAsString();
		assertThat(outputForCreatePost).isNotEmpty();
	}
}
