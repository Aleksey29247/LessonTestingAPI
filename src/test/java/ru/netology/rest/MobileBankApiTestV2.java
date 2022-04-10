package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

class MobileBankApiTestV2 {
    Runtime r = Runtime.getRuntime();
    @Test
    void shouldReturnDemoAccounts() throws IOException {
        r.exec("ls");
        r.exec("java -jar artifacts/app-mbank.jar");
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("http://localhost:9999/api/v1")
      // Выполняемые действия
      .when()
          .get("/demo/accounts")
      // Проверки
      .then()
          .statusCode(200)
          // .header("Content-Type", "application/json; charset=UTF-8")
          // специализированные проверки - лучше
          .contentType(ContentType.JSON)
      ;
    }
}
