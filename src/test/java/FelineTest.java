import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Mock
    Feline felineMock;

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void EatMeatCorrectFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void GetFamilyKoshachi() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, result);
    }

    @Test
    public void GetKittensOneKitten() {
        when(felineMock.getKittens()).thenReturn(1);
        int result = felineMock.getKittens();
        assertEquals(1, result);
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void KittensTestOneKittenRealObject() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }
}
