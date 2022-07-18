import java.util.Scanner;
public abstract class transport {
    int transportNumber;
    int remainGas = 100;
    int speed = 0;
    int changeSpeed = 5;
    int maxBusPassenger = 30;
    int maxTexiPassenger = 4;
    int currentPassenger = 0;
    int addPassenger;
    boolean drive;
    String status = "운행";

    public transport(int transportNumber, int remainGas, int speed, int changeSpeed,
                     int maxBusPassenger, int maxTexiPassenger, int currentPassenger, int addPassenger, boolean drive, String status){
        super();
        this.transportNumber = transportNumber;
        this.remainGas = remainGas;
        this.speed = speed;
        this.changeSpeed = changeSpeed;
        this.maxBusPassenger = maxBusPassenger;
        this.maxTexiPassenger = maxTexiPassenger;
        this.currentPassenger = currentPassenger;
        this.addPassenger = addPassenger;
        this.status = status;
    }

    public int getTransportNumber() {
        this.transportNumber = (int)(Math.random() * 9998)+1;
        System.out.println("차량의 번호는 " + transportNumber);
        return transportNumber;
    }

    public int getChangeSpeed() {
        this.changeSpeed = changeSpeed;

        if (this.remainGas >= 10) {
            speed += changeSpeed;
        }
        System.out.println("속도는 " + speed + "입니다.");
        return speed;
    }

    public int getAddPassenger() {
        Scanner sc = new Scanner(System.in);
        this.addPassenger = sc.nextInt();
        return addPassenger;
    }

    public int getCurrentPassenger() {
        return currentPassenger += addPassenger;
    }


}



