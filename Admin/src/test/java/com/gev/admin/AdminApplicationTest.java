package com.gev.admin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.gev.admin.models.Admin;

import net.minidev.json.JSONValue;

@SpringBootTest(classes = AdminApplication.class)
@AutoConfigureMockMvc
public class AdminApplicationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testControllerGetAllAdmin() throws Exception {
		mockMvc.perform(get("/admin/all")).andExpect(status().isFound());
	}
	
	@Test
	public void testControllerGetAdminById() throws Exception {
		mockMvc.perform(get("/admin/6")).andExpect(status().isFound());
	}
	
	@Test
	public void testControllerDeleteById() throws Exception {
		mockMvc.perform(delete("/admin/2/delete")).andExpect(status().isOk());
	}
	
	@Test
	public void testControllerPostAdmin() throws Exception {
		
		Admin admin = new Admin(1, "Yanon", "Dari", "YDM", "Yanon123");
		
		mockMvc.perform(post("/admin/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSONValue.toJSONString(admin)))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void testControllerUpdateAdmin() throws Exception {
		Admin admin = new Admin(3, "Yanon", "Dari", "YDM", "Yanon123");
		mockMvc.perform(put("/admin/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSONValue.toJSONString(admin)))
		.andExpect(status().isOk());
	}
	
	
	
}
