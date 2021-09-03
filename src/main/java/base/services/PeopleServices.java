package base.services;

import java.util.List;
import java.util.stream.Collectors;

import static base.CommonConstants.PEOPLE_END_POINT;
import static io.restassured.RestAssured.given;

public class PeopleServices extends CommonServices{

    StarshipsServices starshipsServices = new StarshipsServices();

    public String getPersonUrlByPersonName(String personName) {
        return  given()
                .spec(request)
                .basePath(PEOPLE_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .get(String.format("results.find{it.name=='%s'}.url",personName));

    }

    public String getPersonNameByPersonUrl(String personUrl) {
        return  given()
                .spec(request)
                .basePath(PEOPLE_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .get(String.format("results.find{it.url=='%s'}.name",personUrl));

    }

    public List <String> getStarshipsUrlListByPersonName(String personName) {
        return
                given()
                .spec(request)
                .basePath(PEOPLE_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .get(String.format("results.find{it.name=='%s'}.starships",personName));
//        return starshipsUrls.stream().map(url->starshipsServices.getStarshipNameByUrl(url)).collect(Collectors.toList());

    }
}
