import java.util.Random;

public class ThermalCamera {

    private Random random = new Random();

    public double readTemperatureC() {
        return 30 + (10 * random.nextDouble());
    }

    public boolean detectHuman(double thresholdC) {
        return readTemperatureC() >= thresholdC;
    }
}
