package publicTransport;

import java.util.Scanner;

public class texi implements transports, transports_text {

    int license1;
    int license2;
    int currentPassenger;
    int totalpay = 0;
    int currentSpeed;
    int changeSpeed;
    int currentOil = 100;
    int leftoverOil;
    int distance;
    String location;
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("택시");
        license1 = (int) (Math.random() * 9999) + 1;
        license2 = (int) (Math.random() * 9999) + 1;
        System.out.println("첫번째 택시 번호는 " + license1 + "입니다.");
        System.out.println("두번째 택시 번호는 " + license2 + "입니다.");
        System.out.println("현재 주유량은 " + currentOil + "입니다.");
        transports_text.normal();
        transports_text.slash();
    }
    @Override
    public void inPassenger() {
        while (true) {
            transports_text.inputcurrent();
            currentPassenger = scan.nextInt();
            if (currentPassenger <= maxTexiPassenger) {
                System.out.println("현재 승객 수는 " + currentPassenger + "명입니다.");
                System.out.println("잔여 승객 수는 " + (4 - currentPassenger) + "명입니다.");
                System.out.println("기본요금은 3000원 입니다.");
                System.out.println("목적지를 입력해주세요: ");
                scan.nextLine();
                location = scan.nextLine();
                System.out.println("목적지는 " + location + "입니다.");
                System.out.println("목적지까지 거리를 입력해주세요: ");
                distance = scan.nextInt();
                System.out.println("목적지까지 거리는 " + distance + "Km입니다.");
                totalpay += (3000 + 1000 * (distance - 1));
                System.out.println("지불하실 금액은 " + (3000 + 1000 * (distance - 1)) + "입니다.");
                transports_text.work();
                System.out.println("탑승이 불가능합니다.");
                transports_text.slash();
                break;
            } else {
                transports_text.passengerfull();
                transports_text.slash();
            }
        }
    }
    @Override
    public void currentSpeedChange() {
        transports_text.inputspeed();
        currentSpeed = scan.nextInt();
        System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
        transports_text.slash();
    }

    @Override
    public void speedUpdate() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do {
            transports_text.changespeedquestion();
            transports_text.choicespeed();

            int menu = Integer.parseInt(scan.nextLine());
            switch (menu) {
                case 1:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    transports_text.inputplusspeed();

                    Scanner scan1 = new Scanner(System.in);
                    changeSpeed = scan1.nextInt();
                    currentSpeed = currentSpeed + changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    transports_text.slash();
                    break;
                case 2:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    transports_text.inputminusspeed();

                    Scanner scan2 = new Scanner(System.in);
                    changeSpeed = scan2.nextInt();
                    currentSpeed = currentSpeed - changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    transports_text.slash();
                    break;
                case 3:
                    transports_text.slash();
                    isExit = true;
                    break;
            }

        } while (!isExit);
    }
    @Override
    public void oilStatus() {
        transports_text.minusoil();
        leftoverOil = scan.nextInt();
        currentOil -= leftoverOil;
        if (currentOil >= oilCutline) {
            transports_text.work();
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            this.inPassenger();
            this.speedUpdate();
            this.oilStatus();
            transports_text.slash();
        } else {
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            transports_text.lackOil();
            transports_text.gohome();
            transports_text.slash();
            this.oilRefill();
        }
    }

    @Override
    public void oilRefill() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do {
            transports_text.home();
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            transports_text.wantfill();
            transports_text.yesorno();

            int menu = Integer.parseInt(scan.nextLine());
            switch (menu) {
                case 1:
                    currentOil += 10;
                    transports_text.tenoil();
                    transports_text.slash();
                    this.inPassenger();
                    this.speedUpdate();
                    this.oilStatus();
                    break;
                case 2:
                    transports_text.end();
                    System.out.println("오늘의 누적금액은 " + totalpay + "입니다.");
                    transports_text.slash();
                    isExit = true;
                    break;
            }

        } while (!isExit);
    }
}
