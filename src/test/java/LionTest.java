import com.example.Lion;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensExpectedCount() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самка", feline);
        int kittens = lion.getKittens();
        assertEquals(3, kittens);
    }

    @Test
    public void getFoodPredatorFoodList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", feline);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void conctructorExceptionWithMessage() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("НекорректныйПол", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
