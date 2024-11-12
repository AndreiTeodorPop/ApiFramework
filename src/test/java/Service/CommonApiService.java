package Service;

import RestClient.RequestType;
import RestClient.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonApiService {

    public Response post(Object body, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_POST);

        Response response = performRequest(RequestType.REQUEST_POST, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response post(Object body, String endPoint, String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_POST);

        Response response = performRequest(RequestType.REQUEST_POST, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response put(Object body, String endPoint, String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_PUT);

        Response response = performRequest(RequestType.REQUEST_PUT, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response get(String token, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_GET);

        Response response = performRequest(RequestType.REQUEST_GET, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response delete(String token, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_DELETE);

        Response response = performRequest(RequestType.REQUEST_DELETE, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response delete(Object body, String token, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endPoint, RequestType.REQUEST_DELETE);

        Response response = performRequest(RequestType.REQUEST_DELETE, requestSpecification, endPoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endPoint);
    }

}
