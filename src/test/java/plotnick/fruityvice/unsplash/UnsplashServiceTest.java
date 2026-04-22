package plotnick.fruityvice.unsplash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UnsplashServiceTest
{
    @Test
    void getUnsplash()
    {
        //given
        UnsplashService service = new UnsplashServiceFactory().create();

        //when
        Photos photos = service.search("strawberry").blockingGet();

        //then
        assertNotNull(photos);



    }
}
