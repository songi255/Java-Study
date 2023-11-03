import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

public class ForLoopOptimizingTest {
    static List<Long> test1List;
    static List<Long> test2List;
    static Object[] objects = new Object[100000];
    static Object temp = null;

    @BeforeAll
    static void setup() {
        test1List = new ArrayList<>();
        test2List = new ArrayList<>();
    }

    @AfterAll
    static void printResult() {
        System.out.println("test1 : " + test1List);
        System.out.println("test2 : " + test2List);
        int test2FasterCount = 0;
        for (int i = 0; i < test2List.size(); i++) {
            test2FasterCount += (test2List.get(i) < test1List.get(i)) ? 1 : 0;
        }
        System.out.println("Test2 was faster : " + test2FasterCount + "/" + test1List.size());
    }

    @RepeatedTest(1000)
    void test1() {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            Object obj = new Object();
            //temp = obj;
        }
        long end = System.nanoTime();

        test1List.add((end - start));
    }

    @RepeatedTest(1000)
    void test2() {
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Object obj = new Object();
            //temp = obj;
        }
        long end = System.nanoTime();

        test2List.add((end - start));
    }
}