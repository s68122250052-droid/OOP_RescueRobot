public class Battery {

    private double level; // percentage

    public Battery(double level) {
        this.level = level;
    }

    public void drain(double amount) {
        level -= amount;
        if (level < 0) level = 0;
    }

    public void charge(double amount) {
        level += amount;
        if (level > 100) level = 100;
    }

    public double getLevel() {
        return level;
    }

    public boolean isEmpty() {
        return level <= 0;
    }
}
