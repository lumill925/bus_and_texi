import java.util.Scanner;

public class texi extends transport{

    int texipay;
    int distance;
    String alert = "최대 승객 수 초과";

    public texi(int transportNumber, int remainGas, int speed, int changeSpeed, int maxBusPassenger, int maxTexiPassenger, int currentPassenger, int addPassenger, boolean drive, String status) {
        super(transportNumber, remainGas, speed, changeSpeed, maxBusPassenger, maxTexiPassenger, currentPassenger, addPassenger, drive, status);
        this.texipay = texipay;
        this.distance = distance;
    }

    public int getAddDistance() {
        Scanner sc = new Scanner(System.in);
        this.distance = sc.nextInt();
        return distance;
    }

    public int gettexipay() {
        return texipay = 3000 + 1000 * distance;
    }

    public String alert() {
        if(currentPassenger > maxTexiPassenger){
            System.out.println(alert);
        }
        return null;
    }

    public boolean getdrive() {
        if (this.remainGas >= 10) {
            System.out.println("기름이 " + remainGas + "남았습니다.");
            System.out.println("운행중입니다.");
            remainGas -= 5;
            return true;
        } else {
            System.out.println("기름이 " + remainGas + "남았습니다.");
            System.out.println("주유가 필요합니다");
            System.out.println("운행불가입니다.");
            status = "운행불가";
            return false;
        }
    }


}
