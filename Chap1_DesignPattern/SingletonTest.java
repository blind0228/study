package Chap1_DesignPattern;


/*  
    * 싱글톤 패턴. 
    * 싱글톤 패턴은 클래스의 인스턴스를 하나만 생성하고, 그 인스턴스에 대한 전역적인 접근점을 제공하는 디자인 패턴입니다.
    * 싱글톤 패턴을 구현하는 방법은 여러 가지가 있지만, 가장 일반적인 방법은 클래스 내부에 private static 변수를 선언하고, public static 메서드를 통해
    * 그 인스턴스를 반환하는 것입니다. 이렇게 하면 클래스 외부에서 인스턴스를 직접 생성할 수 없고, 항상 동일한 인스턴스를 사용하게 됩니다.
*/

class Singleton {
    private static SingletonTest instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static SingletonTest getInstance() {
        if (instance == null) {                     
            instance = new SingletonTest();         
        }
        return instance;
    }
}


public class SingletonTest {
    
    public static void main(String[] args) {
        SingletonTest singleton1 = Singleton.getInstance();
        SingletonTest singleton2 = Singleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("Both instances are the same. Singleton pattern works!");
        } else {
            System.out.println("Instances are different. Singleton pattern failed.");
        }
    }

}

