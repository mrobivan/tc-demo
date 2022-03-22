package com.dbs.tcdemo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.HttpHeaders;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TcDemoApplicationTests {

	@LocalServerPort
	int randomServerPort = 0;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders httpHeaders = new HttpHeaders();

	@Test
	void returnsListOfPersons() throws JSONException {
		var entity = new HttpEntity<String>(null, httpHeaders);
		var response = restTemplate.exchange(
				createUrlWithPort("/persons"),
				HttpMethod.GET, entity, String.class);
		var expected = "[{name:\"Robert Fripp\"},{name:\"Bill Bruford\"}]";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createUrlWithPort(String uri) {
		return "http://localhost:" + randomServerPort + uri;
	}

}
