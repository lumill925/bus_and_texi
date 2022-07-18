package publicTransport;

import java.util.Scanner;

public class bus implements transports{

    int license1;
    int license2;
    int currentPassenger;
    int changeSpeed;
    int currentOil;
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        license1 = (int)(Math.random() * 9999)+1;
        license2 = (int)(Math.random() * 9999)+1;
        System.out.println("첫번째 버스 번호는 " + license1 + "입니다.");
        System.out.println("두번째 버스 번호는 " + license2 + "입니다.");
        System.out.println("현재 주유량은 " + firstOil + "입니다.");
        transports.normal();
    }

    public void inPassenger() {

        while(true){
            System.out.println("탑승한 승객 숫자를 입력: ");
            currentPassenger = scan.nextInt();
            if (currentPassenger <= maxBusPassenger) {
                System.out.println("현재 승객 수는 " + currentPassenger + "명입니다.");
                System.out.println("잔여 승객 수는 " + (30-currentPassenger) + "명입니다.");
                System.out.println("현재 요금은 " + (1000*currentPassenger) + "원입니다.");
                break;
            } else {
                transports.full();
            }
        }
    }

    public void speedChange() {
        System.out.println("현재 속도 입력: ");
        changeSpeed = scan.nextInt();
        System.out.println("현재 속도는 " + changeSpeed + "Km/h입니다.");
    }

    public void status() {
        System.out.println("감소 주유량: ");
        currentOil = scan.nextInt();
        int leftoverOil = firstOil - currentOil;
        if (leftoverOil >= oilCutline ) {
            transports.work();
            System.out.println("남은 주유량은 " + leftoverOil + "입니다.");
        } else {
            System.out.println("남은 주유량은 " + leftoverOil + "입니다.");
            transports.lackOil();
            transports.gohome();
        }
    }

    @Override
    public void finish() {
    }
}
