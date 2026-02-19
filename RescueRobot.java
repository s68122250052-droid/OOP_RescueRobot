public class RescueRobot implements Flyable, Drivable, ThermalSensor, Communicable {

    private String deviceId;
    private Battery battery;
    private GPSTracker gps;
    private ThermalCamera thermal;

    public RescueRobot(String deviceId) {
        this.deviceId = deviceId;
        this.battery = new Battery(100);
        this.gps = new GPSTracker();
        this.thermal = new ThermalCamera();
    }

    // ========================
    // Override status() conflict
    // ========================
    @Override
    public String status() {
        return "ROBOT: "
                + Flyable.super.status()
                + " + "
                + Drivable.super.status();
    }

    // ========================
    // Flyable
    // ========================
    @Override
    public void takeOff() {
        if (!battery.isEmpty()) {
            battery.drain(10);
            System.out.println("[FLIGHT] Taking off...");
        }
    }

    @Override
    public void land() {
        battery.drain(5);
        System.out.println("[FLIGHT] Landing...");
    }

    @Override
    public double maxAltitude() {
        return 500.0;
    }

    // ========================
    // Drivable
    // ========================
    @Override
    public void startEngine() {
        battery.drain(5);
        System.out.println("[DRIVE] Engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("[DRIVE] Engine stopped");
    }

    @Override
    public double maxSpeed() {
        return 80.0;
    }

    // ========================
    // ThermalSensor
    // ========================
    @Override
    public double readTemperatureC() {
        battery.drain(1);
        double temp = thermal.readTemperatureC();
        System.out.println("[SENSOR] Temperature: " + temp);
        return temp;
    }

    @Override
    public boolean detectHuman(double thresholdC) {
        battery.drain(1);
        boolean result = thermal.detectHuman(thresholdC);
        System.out.println("[SENSOR] Human detected: " + result);
        return result;
    }

    // ========================
    // Communicable
    // ========================
    @Override
    public void send(String message) {
        battery.drain(2);
        System.out.println("[COMM]");
        System.out.println("ID=" + deviceId);
        System.out.println("POS=" + gps.currentPosition());
        System.out.println("MSG=" + message);
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    // ========================
    // Extra
    // ========================
    public void updatePosition(double lat, double lon) {
        gps.updatePosition(lat, lon);
    }
}
