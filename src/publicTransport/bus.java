package publicTransport;

import java.util.Scanner;

public class bus implements transports {

    int license1;
    int license2;
    int currentPassenger;
    int totalpay = 0;
    int currentSpeed;
    int changeSpeed;
    int currentOil = 100;
    int leftoverOil;
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("버스");
        license1 = (int) (Math.random() * 9999) + 1;
        license2 = (int) (Math.random() * 9999) + 1;
        System.out.println("첫번째 버스 번호는 " + license1 + "입니다.");
        System.out.println("두번째 버스 번호는 " + license2 + "입니다.");
        System.out.println("현재 주유량은 " + currentOil + "입니다.");
        transports.normal();
        transports.slash();
    }

    public void inPassenger() {

        while (true) {
            transports.inputcurrent();
            currentPassenger = scan.nextInt();
            if (currentPassenger <= maxBusPassenger) {
                System.out.println("현재 승객 수는 " + currentPassenger + "명입니다.");
                System.out.println("잔여 승객 수는 " + (30 - currentPassenger) + "명입니다.");
                totalpay += 1000 * currentPassenger;
                System.out.println("현재 요금은 " + (1000 * currentPassenger) + "원입니다.");
                transports.slash();
                break;
            } else {
                transports.passengerfull();
                transports.slash();
            }
        }
    }

    public void currentSpeedChange() {
        transports.inputspeed();
        currentSpeed = scan.nextInt();
        System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
        transports.slash();
    }

    @Override
    public void speedUpdate() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do {
            transports.changespeedquestion();
            transports.choicespeed();

            int menu = Integer.parseInt(scan.nextLine());
            switch (menu) {
                case 1:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    transports.inputplusspeed();

                    Scanner scan1 = new Scanner(System.in);
                    changeSpeed = scan1.nextInt();
                    currentSpeed = currentSpeed + changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    transports.slash();
                    break;
                case 2:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    transports.inputminusspeed();

                    Scanner scan2 = new Scanner(System.in);
                    changeSpeed = scan2.nextInt();
                    currentSpeed = currentSpeed - changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    transports.slash();
                    break;
                case 3:
                    transports.slash();
                    isExit = true;
                    break;
            }

        } while (!isExit);
    }

    public void oilStatus() {
        transports.minusoil();
        leftoverOil = scan.nextInt();
        currentOil -= leftoverOil;
        if (currentOil >= oilCutline) {
            transports.work();
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            this.inPassenger();
            this.speedUpdate();
            this.oilStatus();
            transports.slash();
        } else {
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            transports.lackOil();
            transports.gohome();
            transports.slash();
            this.oilRefill();
        }
    }

    @Override
    public void oilRefill() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do {
            transports.home();
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            transports.wantfill();
            transports.yesorno();

            int menu = Integer.parseInt(scan.nextLine());
            switch (menu) {
                case 1:
                    currentOil += 10;
                    transports.tenoil();
                    transports.slash();
                    this.inPassenger();
                    this.speedUpdate(); // 속도 변화시키는 부분
                    this.oilStatus();
                    break;
                case 2:
                    transports.end();
                    System.out.println("오늘의 누적금액은 " + totalpay + "입니다.");
                    isExit = true;
                    break;
            }

        } while (!isExit);
    }
}
