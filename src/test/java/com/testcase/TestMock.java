package com.testcase;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 *  all mappings: http://localhost:8080/__admin/
 *  
 *  
 *  
 *  @Author Sheetal Singh
 *  @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
public class TestMock {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	private static WireMockServer server = new WireMockServer(PORT);


	/**
	 * Start Wiremock server via Code and configure it with required host and port
	 */
	@BeforeClass
	public void initializeServer() {
		System.out.println("Init");
		server.start();
		WireMock.configureFor(HOST, PORT);

		/*
		//to check all mappings http://localhost:8080/__admin/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		*/
	}


	/**
	 * mappings/employee.json
	 */
	@Test
	public void testEmployeeEndpoint() {
		String testApi = "http://localhost:"+ PORT +"/emps/1";
		System.out.println("Service to be hit: "+testApi);
		String tokenInHeader =
				RestAssured.
						given().
							get(testApi).
						then().
							assertThat().
							statusCode(200).
						extract().
							header("token");

		Assert.assertEquals(tokenInHeader, "12345");
	}

	/**
	 * mappings/songs.json
	 * with proper json body
	 */
	@Test
	public void testSongEndpoint() {
		String testApi = "http://localhost:"+ PORT +"/api/my-songs";
		System.out.println("Service to be hit: "+testApi);

		Response response =
			RestAssured.
				given().
					get(testApi).
				then().
					assertThat().
					statusCode(200).
				extract().
					response();

		//Verification
		JsonPath jsonPath= response.jsonPath();
		List<String> listOfIds = jsonPath.getList("id");
		System.out.println("#ListOfIds: "+listOfIds);
		Assert.assertEquals(listOfIds.get(1), "565656");
	}

	@AfterClass
	public void closeServer() {
		System.out.println("End");
		if (server.isRunning() && null != server) {
			server.shutdown();
		}
	}

}
