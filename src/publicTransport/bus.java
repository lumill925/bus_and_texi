package publicTransport;

import java.util.Scanner;

public class bus implements transports{

    int license1;
    int license2;
    int currentPassenger;
    int totalpay=0;
    int currentSpeed;
    int changeSpeed;
    int currentOil=100;
    int leftoverOil;
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        license1 = (int)(Math.random() * 9999)+1;
        license2 = (int)(Math.random() * 9999)+1;
        System.out.println("첫번째 버스 번호는 " + license1 + "입니다.");
        System.out.println("두번째 버스 번호는 " + license2 + "입니다.");
        System.out.println("현재 주유량은 " + currentOil + "입니다.");
        transports.normal();
        System.out.println("====================================");
    }

    public void inPassenger() {

        while(true){
            System.out.println("탑승한 승객 숫자를 입력: ");
            currentPassenger = scan.nextInt();
            if (currentPassenger <= maxBusPassenger) {
                System.out.println("현재 승객 수는 " + currentPassenger + "명입니다.");
                System.out.println("잔여 승객 수는 " + (30-currentPassenger) + "명입니다.");
                totalpay += 1000*currentPassenger;
                System.out.println("현재 요금은 " + (1000*currentPassenger) + "원입니다.");
                System.out.println("====================================");
                break;
            } else {
                transports.full();
                System.out.println("====================================");
            }
        }
    }

    public void speedChange() {
        System.out.println("현재 속도 입력: ");
        currentSpeed = scan.nextInt();
        System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
        System.out.println("====================================");
    }

    @Override
    public void speedUpdate() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("속도를 조절 하시겠습니까?");
            System.out.println("1. 속도 상승    2. 속도 감소    3. 아니요");

            int menu = Integer.parseInt(scan.nextLine());
            switch(menu) {
                case 1:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    System.out.println("증가할 속도 입력: ");

                    Scanner scan1 = new Scanner(System.in);
                    changeSpeed = scan1.nextInt();
                    currentSpeed = currentSpeed + changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    System.out.println("====================================");
                    break;
                case 2:
                    System.out.println("현재 속도는 " + currentSpeed + "Km/h입니다.");
                    System.out.println("감소할 속도 입력: ");

                    Scanner scan2 = new Scanner(System.in);
                    changeSpeed = scan2.nextInt();
                    currentSpeed = currentSpeed - changeSpeed;
                    System.out.println("현재 속도는 " + (currentSpeed) + "Km/h입니다.");
                    System.out.println("====================================");
                    break;
                case 3:
                    System.out.println("====================================");
                    isExit = true;
                    break;
            }

        } while(!isExit);
    }

    public void status1() {
//        System.out.println("감소 주유량: ");
//        currentOil = scan.nextInt();
//        leftoverOil = firstOil - currentOil;
//        if (leftoverOil >= oilCutline ) {
//            transports.work();
//            System.out.println("남은 주유량은 " + leftoverOil + "입니다.");
//            System.out.println("====================================");
//        } else {
//            System.out.println("남은 주유량은 " + leftoverOil + "입니다.");
//            transports.lackOil();
//            transports.gohome();
//            System.out.println("====================================");
//        }
    }

    public void status2() {
        System.out.println("감소 주유량: ");
        leftoverOil = scan.nextInt();
        currentOil -= leftoverOil;
        if (currentOil >= oilCutline ) {
            transports.work();
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            this.inPassenger();
            this.speedChange();
            this.speedUpdate();
            this.status2();
            System.out.println("====================================");
        } else {
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            transports.lackOil();
            transports.gohome();
            System.out.println("====================================");
            this.refill();
        }
    }

    @Override
    public void refill() {

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("차고지입니다.");
            System.out.println("남은 주유량은 " + currentOil + "입니다.");
            System.out.println("채우시겠습니까?");
            System.out.println("1.네    2.아니요");

            int menu = Integer.parseInt(scan.nextLine());
            switch(menu){
                case 1:
                    currentOil = 100;
                    System.out.println("가득채워졌습니다.");
                    System.out.println("====================================");
                    this.inPassenger();
                    this.speedChange();
                    this.speedUpdate();
                    this.status1();
                    break;
                case 2:
                    System.out.println("운행을 종료합니다.");
                    System.out.println("오늘의 누적금액은 " + totalpay + "입니다.");
                    isExit = true;
                    break;
            }

        }while(!isExit);
    }

    @Override
    public void replay() {

    }
}
