package base.services;

import static base.CommonConstants.FILMS_END_POINT;
import static io.restassured.RestAssured.given;

public class FilmsServices extends CommonServices {

    PeopleServices peopleServices = new PeopleServices();

    public boolean isCharacterInFilm(String characterName, String filmName){
        String personUrl = peopleServices.getPersonUrlByPersonName(characterName);
        return given()
                .spec(request)
                .basePath(FILMS_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .getList(String.format("results.find{it.title=='%s'}.characters",filmName))
                .contains(personUrl);
    }

}
