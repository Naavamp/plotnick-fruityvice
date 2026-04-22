package plotnick.fruityvice.unsplash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UnsplashServiceTest
{
    @Test
    public void search()
    {
        //given
        UnsplashService service = new UnsplashServiceFactory().create();

        //when
        Photos photos = service.search("strawberry").blockingGet();

        //then
        assertNotNull(photos.results.get(0).urls.small);



    }
}
