package com.example.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.example.blog.application.usecase.dto.PostOutputDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class GetPostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Description("It should get a post via API")
	public void getPostViaAPI() throws JsonProcessingException, Exception {
		PostInputDTO inputForCreatePost = new PostInputDTO("The Enigmatic Journey of Cosmic Whispers",
				"Embark on a mysterious exploration through the celestial realms where whispers from the cosmos reveal secrets of the unknown. Join this enigmatic journey of discovery and transcendence",
				LocalDateTime.parse("2024-02-02T17:06:30"));
		MvcResult returnOfCallCreatePost = this.mockMvc
				.perform(post("/api/v1/post/createPost").header("Content-Type", "application/json")
						.content(this.objectMapper.writeValueAsBytes(inputForCreatePost)))
				.andExpect(status().isOk()).andReturn();
		String outputForCreatePost = returnOfCallCreatePost.getResponse().getContentAsString();
		MvcResult returnOfCallGetPost = this.mockMvc.perform(
				get("/api/v1/post/getPost/{postId}", outputForCreatePost).header("Content-Type", "application/json"))
				.andExpect(status().isOk()).andReturn();
		String contentAsString = returnOfCallGetPost.getResponse().getContentAsString();
		PostOutputDTO outputForGetPost = this.objectMapper.readValue(contentAsString,
				new TypeReference<PostOutputDTO>() {
				});
		assertThat(outputForGetPost.title()).isEqualTo(inputForCreatePost.title());
		assertThat(outputForGetPost.content()).isEqualTo(inputForCreatePost.content());
	}
	
	@Test
	@Description("It should thrown a exception via API if the post does not exist")
	public void thrownExceptionViaAPI() {
		
	}
}
