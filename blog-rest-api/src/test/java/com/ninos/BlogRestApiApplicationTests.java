package com.ninos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninos.dto.PostDto;
import com.ninos.model.Post;
import com.ninos.repository.PostRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BlogRestApiApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PostRepository postRepository;  // we inject PostRepository just because we want to use deleteAll()


	@BeforeEach
	void setup(){
		postRepository.deleteAll();
	}


	@DisplayName("Create New Post")
	@Test
	public void createPostController() throws Exception {
		// given
		PostDto postDto = new PostDto("java","Explain all java concepts","Java For Beginner");

		// when
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("http://8080/api/v1/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(postDto)));

		// then
		response.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(postDto.getTitle())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(postDto.getDescription())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.content", CoreMatchers.is(postDto.getContent())));

	}



    @DisplayName("Get All Posts From Database")
	@Test
	public void getAllPostsController() throws Exception{
		// given
		List<Post> list = new ArrayList<>();
		list.add(new Post("java","learn java for beginner","java concepts"));
		list.add(new Post("c++","learn c++ for beginner","c++ concepts"));
		postRepository.saveAll(list);

		// when
		ResultActions response = mockMvc.perform(get("http://8080/api/v1/posts"));

		// then
		response.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(list.size())));
	}




}
