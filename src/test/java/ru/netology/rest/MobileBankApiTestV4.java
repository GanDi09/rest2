package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class MobileBankApiTestV4 {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")

                .then()
                .statusCode(200)
                .body("", hasSize(2))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                .header("Content-Type", "application/json; charset=UTF-8")

                .body("[0].currency", equalTo("RUB"))
        ;
    }
}
