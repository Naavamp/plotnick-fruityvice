package plotnick.fruityvice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruityServiceTest
{
    @Test
    void getFruit()
    {
        //given
        FruityService service = new FruityServiceFactory().create();

        //when
        Fruit Fruit = service.getFruit("Strawberry").blockingGet();

        //then
        assertEquals("Strawberry", Fruit.name());
        assertEquals(3, Fruit.id());
        assertEquals("Rosaceae", Fruit.family());
        assertEquals("Rosales", Fruit.order());
        assertEquals("Fragaria", Fruit.genus());
        Nutritions nutritions = Fruit.nutritions();
        assertEquals(29, nutritions.calories());
        assertEquals(0.4, nutritions.fat());
        assertEquals(5.4, nutritions.sugar());
        assertEquals(5.5, nutritions.carbohydrates());
        assertEquals(0.8, nutritions.protein());



    }
}