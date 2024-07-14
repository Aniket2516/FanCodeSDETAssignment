package utils;
import constants.Endpoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CommonUtilites {
    public static Response getAPIResponse(String endPoint) {
        Response response;
        String endPt = null;
        switch (endPoint)
        {
            case "USERS":
                endPt= Endpoints.USERS;
                break;
            case "TODOS":
                endPt= Endpoints.TODOS;
                break;
            case "POSTS":
                endPt= Endpoints.POSTS;
                break;
            case "ALBUMS":
                endPt= Endpoints.ALBUMS;
                break;
            case "PHOTOS":
                endPt= Endpoints.PHOTOS;
                break;
            case "COMMENTS":
                endPt= Endpoints.COMMENTS;
                break;
        }
        response= given().
                when().
                get(endPt).
                then().extract().response();
        return response;
    }

    public static Response getAPIResponse(String endPoint, int userId) {
        Response response;
        String endPt=null;
        switch (endPoint)
        {
            case "USERS":
                endPt= Endpoints.USERS;
                break;
            case "TODOS":
                endPt= Endpoints.TODOS;
                break;
            case "POSTS":
                endPt= Endpoints.POSTS;
                break;
            case "ALBUMS":
                endPt= Endpoints.ALBUMS;
                break;
            case "PHOTOS":
                endPt= Endpoints.PHOTOS;
                break;
            case "COMMENTS":
                endPt= Endpoints.COMMENTS;
                break;
        }
        response= given().
                queryParam("userId", userId).
                when().
                get(endPt).
                then().extract().response();
        return response;
    }
}
