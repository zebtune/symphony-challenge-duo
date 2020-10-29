import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.github.javafaker.Faker;

import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ApiTestPOST {
    //Faker for random generated data
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    @Test
    public void createUser() {

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String mail = faker.bothify(fakeValuesService.bothify("#?????##@gmail.com"));
        int age = faker.number().randomDigitNotZero();
        int id = 20;

        JSONObject request = new JSONObject();

        request.put("firstName", fName);
        request.put("lastName", lName);
        request.put("email", mail);
        request.put("age", age);
        request.put("id", id);

        System.out.println(request.toString());

        given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
    }

    @Test
    public void getNewUser() {
        JSONObject request = new JSONObject();
        //we get "not found" because the user is not actually created
        given().body(request.toJSONString()).when().get("https://reqres.in/api/users/20").then().statusCode(404);
    }

    @Test
    public void createUserWithAnyParameter() {
        JSONObject request = new JSONObject();

        //we can put anything as an parameter option and it will be created
        request.put(faker.animal().name(), "anything");
        System.out.println(request.toString());

        given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
    }
}

