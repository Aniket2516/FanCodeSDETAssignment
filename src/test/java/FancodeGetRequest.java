import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import utils.CommonUtilites;



public class FancodeGetRequest  {
    private static final Logger LOGGER = LoggerFactory.getLogger(FancodeGetRequest.class);

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }


    @Test
    public void verifyFanCodeUsersTodoTaskCompletion() {
        Response userResponse = CommonUtilites.getAPIResponse("USERS");
        Assert.assertTrue(userResponse.getStatusCode() == 200);
        LOGGER.info("Users fetched successfully.");


        JsonArray usersArray = JsonParser.parseString(userResponse.getBody().asString()).getAsJsonArray();
        LOGGER.info("Number of users fetched: {}", usersArray.size());


        for (JsonElement userElement : usersArray) {
            JsonObject user = userElement.getAsJsonObject();
            double lat = user.getAsJsonObject("address").getAsJsonObject("geo").get("lat").getAsDouble();
            double lng = user.getAsJsonObject("address").getAsJsonObject("geo").get("lng").getAsDouble();

            if (lat >= Constants.LAT_START && lat <= Constants.LAT_END
                    && lng >= Constants.LONG_START
                    && lng <= Constants.LONG_END)
            {
                int userId = user.get("id").getAsInt();
                LOGGER.info("User ID {} belongs to FanCode city (lat: {}, lng: {}). Fetching todos...", userId, lat, lng);

                Response todoResponse = CommonUtilites.getAPIResponse("TODOS", userId);
                Assert.assertTrue(todoResponse.getStatusCode() == 200);

                JsonArray todosArray = JsonParser.parseString(todoResponse.getBody().asString()).getAsJsonArray();
                LOGGER.info("Number of todos for user ID {}: {}", userId, todosArray.size());


                int completedCount = 0;
                for (JsonElement todoElement : todosArray) {
                    JsonObject todo = todoElement.getAsJsonObject();
                    if (todo.get("completed").getAsBoolean()) {
                        completedCount++;
                    }
                }

                double completionPercentage = ((double) completedCount / todosArray.size()) * 100;
                LOGGER.info("User ID {} has {}% tasks completed.", userId, completionPercentage);


                Assert.assertTrue(completionPercentage > 50, "User ID " + userId + " has less than 50% tasks completed.");
                LOGGER.info("User ID {} passed the completion percentage check.", userId);

            }
        }
    }
}