package publicTransport;

public interface transports {
    int maxBusPassenger = 30;
    int maxTexiPassenger = 4;
    int firstOil = 100;
    int oilCutline = 10;

    void start();
    void inPassenger();
    void speedChange();
    void status();
    void finish();
    static void normal() {
        System.out.println("일반상태입니다.");
    }
    static void work() {
        System.out.println("운행중입니다.");
    }
    static void gohome() {
        System.out.println("차고지행입니다.");
    }

    static void full() {
        System.out.println("최대 승객 수 초과입니다.");
    }
    static void lackOil() {
        System.out.println("주유가 필요합니다.");
    }
}
