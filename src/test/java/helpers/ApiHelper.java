package helpers;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static String getMethodForPayWay (DataHelper.CardInformationModel info) {
        var body = info;
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/pay")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }
    public static String getMethodForCreditWay (DataHelper.CardInformationModel info) {
        var body = info;
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/credit")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }
}
