public class GPSTracker {

    private double latitude;
    private double longitude;

    public void updatePosition(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public String currentPosition() {
        return latitude + "," + longitude;
    }
}
