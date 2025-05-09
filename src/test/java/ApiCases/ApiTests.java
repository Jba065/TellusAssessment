package ApiCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {
    @Test
    public void apiChainingTest() throws InterruptedException {

            // First API call to get a user ID
            Response response1 = given()
                    .baseUri("https://reqres.in/api")
                    .when()
                    .get("/users?page=2")
                    .then()
                    .statusCode(200)
                    .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                    .extract()
                    .response();

            // Extract the user ID from the first response
            int userId = response1.jsonPath().getInt("data[0].id");


            System.out.println("Extracted User ID: " + userId);


            // Second API call using the extracted user ID
            Response response2 = given()
                    .baseUri("https://reqres.in/api")
                    .header("X-API-Key", "reqres-free-v1")
                    .pathParam("userId", userId)
                    .when()
                    .get("/users/{userId}")
                    .then()
                    .statusCode(200)
                    .body("data.first_name", equalTo("Michael"))
                    .extract()
                    .response();

            // You can further process the response from the second API

            String email = response2.jsonPath().getString("data.email");
            System.out.println("Email from second API: " + email);
        }

    @Test
    public void testingFileUpload() {
        // The ID of the user you want to "update"
        int userId = 2; // You can choose any existing user ID

        // Path to the file you want to "upload" (replace with your actual file)
        File fileToUpload = new File("src/test/resources/apiSampleFileToUpload.txt");

        // Ensure the file exists
        if (!fileToUpload.exists()) {
            System.err.println("File not found: " + fileToUpload.getAbsolutePath());
            return;
        }

        Response response = given()
                .header("X-API-Key", "reqres-free-v1")
                .multiPart("avatar", fileToUpload) // "avatar" is a common field name for user profile pictures
                .param("name", "Updated User") // Add other form parameters if needed
                .param("job", "Software Engineer")
                .when()
                .put("https://reqres.in/api/users/" + userId);

        // Print the response body for inspection
        response.then()
                .log().all()
                .statusCode(200); // Expecting a successful response (though the file might not be processed)

        // You can add assertions based on the response body if it contains any relevant information
        // For example, checking if the updated name is present (though reqres.in might not persist this with multipart)
        response.then()
                .body("name", equalTo("Updated User"))
                .body("job", equalTo("Software Engineer"));
    }
}
