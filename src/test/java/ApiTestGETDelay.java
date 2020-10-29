import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTestGETDelay {

    @Test
    public void delayFive() {

        Response response = RestAssured.get("https://reqres.in/api/users?delay=5");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("Response Time : " + response.getTime());
    }

    @Test
    public void delayUnderFive() {

        Response response = RestAssured.get("https://reqres.in/api/users?delay=3");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("Response Time : " + response.getTime());
    }

    @Test
    public void overFive() {

        Response response = RestAssured.get("https://reqres.in/api/users?delay=9");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("Response Time : " + response.getTime());
    }
}