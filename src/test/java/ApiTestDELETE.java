import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTestDELETE {

    @Test
    public void deleteUsers() {

        JSONObject request = new JSONObject();
        given().body(request.toJSONString()).when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
        //all we get is no body response
        given().body(request.toJSONString()).when().delete("https://reqres.in/api/users/2?id=3").then().statusCode(204).log().all();
    }

    @Test
    public void checkIfUserIsDeleted() {
            Response response = RestAssured.get("https://reqres.in/api/users/2");
            System.out.println(response.statusCode());
            System.out.println(response.asString());
            System.out.println(response.getBody().asString());
            System.out.println(response.statusLine());

            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200); //user is not actually deleted
        }

}