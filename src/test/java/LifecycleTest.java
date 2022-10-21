import org.junit.jupiter.api.*;

class LifecycleTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Setup");
    }

    @Test
    void firstTest(){
        System.out.println("Test 1");
    }

    @Test
    void secondTest(){
        System.out.println("Test 2");
    }

    @Test
    void thirdTest(){
        System.out.println("Test 3");
    }

    @AfterEach
    void tearDown(){
        System.out.println("TearDown");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all");
    }

}
