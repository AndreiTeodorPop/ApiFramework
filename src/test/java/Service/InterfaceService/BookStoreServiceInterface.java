package Service.InterfaceService;

import ObjectData.RequestObject.RequestAccountBook;
import ObjectData.RequestObject.RequestAccountBooks;
import io.restassured.response.Response;

public interface BookStoreServiceInterface {

    Response addBooksToAccount(RequestAccountBooks body, String token);
    Response updateSpecificBook(RequestAccountBook body, String token, String actualBook);
    Response deleteSpecificBook(RequestAccountBook body, String token);
    Response deleteBooks(String token, String userId);

}
