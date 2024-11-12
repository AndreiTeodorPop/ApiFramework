package Service.InterfaceService;

import ObjectData.RequestObject.RequestAccount;
import io.restassured.response.Response;

public interface AccountServiceInterface {

    Response createAccount(RequestAccount body);
    Response generateAccountToken(RequestAccount body);
    Response getSpecificAccount(String token, String userId);
    Response deleteSpecificAccount(String token, String userId);

}
