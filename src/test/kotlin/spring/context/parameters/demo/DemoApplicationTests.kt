package spring.context.parameters.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun contextLoads() {
	}

	@Test
	fun `regular parameter injection works correctly`() {
		mockMvc.perform(get("/parameter"))
			.andExpect(status().isOk)
			.andExpect(content().string("Hello GET"))
	}

	@Test
	fun `context parameter injection fails with 500 error`() {
		mockMvc.perform(get("/context-parameter"))
			.andExpect(status().isOk)
			.andExpect(content().string("Hello GET"))
	}

	@Test
	fun `context parameter with explicit param name works correctly`() {
		mockMvc.perform(get("/context-parameter-with-param-explicit-name")
			.param("name", "World"))
			.andExpect(status().isOk)
			.andExpect(content().string("Hello World GET"))
	}

	@Test
	fun `context parameter with param fails with 500 error`() {
		mockMvc.perform(get("/context-parameter-with-param")
			.param("name", "World"))
			.andExpect(status().isOk)
			.andExpect(content().string("Hello World GET"))
	}
}
