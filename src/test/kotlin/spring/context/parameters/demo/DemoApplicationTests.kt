package spring.context.parameters.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
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
}
