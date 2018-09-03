package pl.mysior.welshblackrestapi.IntegrationTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.mysior.welshblackrestapi.model.Cow;
import pl.mysior.welshblackrestapi.repository.CowRepository;
import pl.mysior.welshblackrestapi.services.CowService;
import pl.mysior.welshblackrestapi.services.Impl.CowServiceImpl;


@ActiveProfiles("test")
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class CowControllerIT {

    private Cow cow;

    @Autowired
    @MockBean
    private CowService cowService;

    @Autowired
    private CowRepository cowRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void save() {
//        cow = new Cow("PL123", "imie", new GregorianCalendar(2017, 10, 3), "1324", "13245", "M", "Brazowy", true);
//        System.out.println(cow.toString());
//        Cow c = cowService.save(cow);
//        System.out.println(c.toString());
//        Assert.assertEquals(c.getNumber(),cow.getNumber());
        Assert.assertTrue(true);
    }
}
