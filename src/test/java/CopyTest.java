import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;

public class CopyTest {
    static ArrayList<Object> objects;
    static ArrayList<Integer> integers;

    @BeforeAll
    static void setup(){
        objects = new ArrayList<>(10000);
        integers = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            objects.add(new Object());
            integers.add(Integer.valueOf(1));
        }
    }

    @RepeatedTest(1000)
    void copy_Wrapper(){
        Integer adding = Integer.valueOf(1);
        long start = System.nanoTime();
        integers.add(adding);
        long end = System.nanoTime();

        //System.out.println((end - start));
    }

    @RepeatedTest(1000)
    void copy_Object(){
        Object adding = new Object();
        long start = System.nanoTime();
        objects.add(adding);
        long end = System.nanoTime();

        //System.out.println((end - start));
    }
}
