import base.services.FilmsServices;
import base.services.PeopleServices;
import base.services.StarshipsServices;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class NewHopeTests {
        FilmsServices filmsServices = new FilmsServices();
        PeopleServices peopleServices = new PeopleServices();
        StarshipsServices starshipsServices = new StarshipsServices();



@Test
public void test(){


        String filmTitle = "A New Hope";
        String personName = "Biggs Darklighter";
        String pilotName = "Luke Skywalker";
        String starshipClass = "Starfighter";

        Assert.assertTrue(filmsServices.isCharacterInFilm(personName,filmTitle)
                ,"Biggs Darklighter doesn't take part in 'A New Hope' film" );

        List<String> biggsShipUrls = peopleServices.getStarshipsUrlListByPersonName(personName);
        List<String> biggsShip = biggsShipUrls.stream().map(url->starshipsServices.getStarshipNameByUrl(url)).collect(Collectors.toList());
        Assert.assertEquals(biggsShip.size(),1);

        List<String> xWingPilots = starshipsServices.getListOfPilotsUrlByName(biggsShip.get(0));
            Assert.assertTrue(xWingPilots.contains(peopleServices.getPersonUrlByPersonName(pilotName)));

            Assert.assertEquals(starshipsServices.getStarshipclassByName(biggsShip.get(0)),starshipClass);

}

}
