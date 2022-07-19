package publicTransport;

public class main {
    public static void main(String[] args){
        transports ts = null;

        ts = new bus();
        ts.start();
        ts.inPassenger();
        ts.currentSpeedChange();
        ts.speedUpdate();
        ts.oilStatus();

        ts = new texi();
        ts.start();
        ts.inPassenger();
        ts.currentSpeedChange();
        ts.speedUpdate();
        ts.oilStatus();
    }
}