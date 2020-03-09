package com.rboudhar001.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import com.rboudhar001.model.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MockMvc mMockMvc;

	// User
	private User mUser;

	@BeforeAll
	public static void initAll() {
	}

	@BeforeEach
	public void init() {

//		mUser = new User();
//		mUser.setId(999L);
//		mUser.setName("Rachid");
//		mUser.setCity("Madrid");

		mUser = new User();
		mUser.setId(6L);
		mUser.setName("Tom");
		mUser.setCity("Cork");
	}

	@Test
	public void context() {
	}

	@Test
	public void list() throws Exception {

		mMockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void view() throws Exception {

		mMockMvc.perform(get("/users/" + mUser.getId())).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void addGET() throws Exception {

		mMockMvc.perform(get("/users/add")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void updateGET() throws Exception {

		mMockMvc.perform(get("/users/" + mUser.getId() + "/update")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void delete() throws Exception {

		mMockMvc.perform(get("/users/" + mUser.getId() + "/delete")).andDo(print()).andExpect(status().isFound());
	}
}
