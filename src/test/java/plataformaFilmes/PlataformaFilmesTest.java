package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {

    @Test
    public void validaLogin(){
        RestAssured.baseURI = "http://localhost:8080/";
        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";
        Response response = post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        String token = response.body().jsonPath().get("token");
        System.out.println(token);

    }

    @Test
    public void validaResponseTipo(){
        RestAssured.baseURI = "http://localhost:8080/";
        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";
        Response response = post(json, ContentType.JSON, "auth");

        assertEquals("Bearer", response.body().jsonPath().get("tipo"));
    }

    public Response post(Object json, ContentType contentType, String endpoint){

        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();
    }
}
