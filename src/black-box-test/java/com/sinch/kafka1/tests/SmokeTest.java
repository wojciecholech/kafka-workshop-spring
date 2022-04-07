package com.sinch.kafka1.tests;

import static io.restassured.RestAssured.given;

import com.sinch.kafka1.BlackBoxTestEnvironment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SmokeTest {

  @Test
  public void healthcheck() {
    // @formatter:off
    given()
        .baseUri(BlackBoxTestEnvironment.serviceUrl())
        .when()
        .get("/healthcheck")
        .then()
        .statusCode(200);
    // @formatter:on
  }

  @BeforeAll
  static void beforeAll() {
    BlackBoxTestEnvironment.start();
  }

}
