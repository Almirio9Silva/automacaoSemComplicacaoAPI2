package plataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import javax.swing.plaf.synth.SynthSliderUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
     static String token;
    @Test
    public void validaLogin(){

        RestUtils.setBaseURI("http://localhost:8080/");
        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";
        Response response = RestUtils.post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        token = response.body().jsonPath().get("token");
        System.out.println(token);

    }

    @Test
    public void validarConsultaCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);

        Response response = RestUtils.get(header, "categorias");
        assertEquals(200, response.statusCode());

        System.out.println(response.jsonPath().get().toString());


        System.out.println(response.jsonPath().get("tipo[2]").toString());
        assertEquals("Terror", response.jsonPath().get("tipo[2]").toString());

        List<String> listTipo = response.jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));


    }



    @BeforeAll
    public static void validarLoginMap(){
        RestUtils.setBaseURI("http://localhost:8080/");
        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        LoginMap.token = response.body().jsonPath().get("token");
    }

    @Test
    public void validaResponseTipo(){
        RestAssured.baseURI = "http://localhost:8080/";
        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";
        Response response = RestUtils.post(json, ContentType.JSON, "auth");

        assertEquals("Bearer", response.body().jsonPath().get("tipo"));
    }


}
