package RestClient;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import xmlFile.GeneralXml;
import xmlFile.xmlNode.Configuration;

public class RestClient {

    private RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        Configuration configuration = GeneralXml.createConfig(Configuration.class);

        requestSpecification.baseUri(configuration.backEndConfig.baseURL);
        requestSpecification.contentType(configuration.backEndConfig.contentType);

        return requestSpecification;
    }

    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint) {
        switch (requestType) {
            case RequestType.REQUEST_POST:
                return prepareClient(requestSpecification).post(endPoint);
            case RequestType.REQUEST_PUT:
                return prepareClient(requestSpecification).put(endPoint);
            case RequestType.REQUEST_DELETE:
                return prepareClient(requestSpecification).delete(endPoint);
            case RequestType.REQUEST_GET:
                return prepareClient(requestSpecification).get(endPoint);
        }

        return null;
    }


}
