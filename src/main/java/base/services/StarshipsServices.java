package base.services;

import java.util.List;

import static base.CommonConstants.STARSHIPS_END_POINT;
import static io.restassured.RestAssured.given;

public class StarshipsServices extends CommonServices{

    public String getStarshipNameByUrl(String url){
        return  given()
                .spec(request)
                .basePath(STARSHIPS_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .get(String.format("results.find{it.url=='%s'}.name",url));
    }

    public String getStarshipclassByName (String starshipname){
        return  given()
                .spec(request)
                .basePath(STARSHIPS_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .get(String.format("results.find{it.name=='%s'}.starship_class",starshipname));
    }

    public List<String> getListOfPilotsUrlByName (String starshipname){
        return given()
                .spec(request)
                .basePath(STARSHIPS_END_POINT)
                .get()
                .then()
                .log().all()
                .spec(responseSuccess)
                .extract()
                .body()
                .jsonPath()
                .getList(String.format("results.find{it.name=='%s'}.pilots",starshipname));

    }


}
