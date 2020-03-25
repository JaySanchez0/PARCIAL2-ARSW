package com.coronavirus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {
	@Autowired
	private MockMvc mock;
	@Test
   public void wouldBeShowCountriesData() throws Exception {
	   mock.perform(get("/coronavirusapi/country")).andExpect(status().is2xxSuccessful());
   }
	@Test
	public void shouldBeFailStatusIfTheCountryIsUnexist() throws Exception {
		mock.perform(get("/coronavirusapi/country/xxxxx")).andExpect(status().is4xxClientError());
	}
	@Test
	public void shouldBeFindACountry() throws Exception {
		mock.perform(get("/coronavirusapi/country/Colombia")).andExpect(status().is2xxSuccessful());
	}
}
