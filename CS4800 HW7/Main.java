public class Main {
    public static void main(String[] args) {
        UnitTests.testAll();
        ProxyDriver proxyDriver = new ProxyDriver();
        proxyDriver.driver();
        FlyweightDriver flyWeightDriver = new FlyweightDriver();
        flyWeightDriver.driver();
    }
}
