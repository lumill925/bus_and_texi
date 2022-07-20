package publicTransport;

public interface transports {
    int maxBusPassenger = 30;
    int maxTexiPassenger = 4;
    int oilCutline = 10;

    void start();

    void inPassenger();

    void currentSpeedChange();

    void speedUpdate();

    void oilStatus();

    void oilRefill();


}
