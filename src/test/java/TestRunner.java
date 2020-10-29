import org.testng.TestNG;

public class TestRunner{
    static TestNG testNG;
    public static void main(String[] args) throws NoClassDefFoundError{

        testNG = new TestNG();
        testNG.setTestClasses(new Class[] {
                ApiTestGET.class,
                ApiTestPOST.class,
                ApiTestGETDelay.class,
                ApiTestDELETE.class});
        testNG.run();
    }
}