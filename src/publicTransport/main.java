package publicTransport;

public class main {
    public static void main(String[] args){
        transports ts = null;

        System.out.println("버스");
        ts = new bus();
        ts.start();
        ts.inPassenger();
        ts.currentSpeedChange();
        ts.speedUpdate();
        ts.oilStatus();
        System.out.println();

        System.out.println("택시");
        ts = new texi();
        ts.start();
        ts.inPassenger();
        ts.currentSpeedChange();
        ts.speedUpdate();
        ts.oilStatus();
        System.out.println();
    }
}