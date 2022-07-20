package publicTransport;

public interface transports_text {

    static void inputcurrent() {
        System.out.println("탑승한 승객 숫자를 입력: ");
    }

    static void inputspeed() {
        System.out.println("현재 속도 입력: ");
    }

    static void changespeedquestion() {
        System.out.println("속도를 조절 하시겠습니까?");
    }

    static void choicespeed() {
        System.out.println("1. 속도 상승    2. 속도 감소    3. 아니요");
    }

    static void inputplusspeed() {
        System.out.println("증가할 속도 입력: ");
    }

    static void inputminusspeed() {
        System.out.println("감소할 속도 입력: ");
    }

    static void minusoil() {
        System.out.println("감소 주유량: ");
    }

    static void normal() {
        System.out.println("일반상태입니다.");
    }

    static void work() {
        System.out.println("운행중입니다.");
    }

    static void gohome() {
        System.out.println("차고지행입니다.");
    }

    static void wantfill() {
        System.out.println("채우시겠습니까?");
    }

    static void home() {
        System.out.println("차고지입니다.");
    }

    static void passengerfull() {
        System.out.println("최대 승객 수 초과입니다.");
    }

    static void lackOil() {
        System.out.println("주유가 필요합니다.");
    }

    static void tenoil() {
        System.out.println("주유량 10이 채워졌습니다.");
    }

    static void yesorno() {
        System.out.println("1.네    2.아니요");
    }

    static void end() {
        System.out.println("운행을 종료합니다.");
    }

    static void slash() {
        System.out.println("====================================");
    }

}
