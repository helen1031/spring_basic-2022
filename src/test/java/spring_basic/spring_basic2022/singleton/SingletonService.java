package spring_basic.spring_basic2022.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // 생성자를 private으로 선언하여 외부 new 객체 생성을 막아야 한다
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
