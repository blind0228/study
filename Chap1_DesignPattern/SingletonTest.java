package Chap1_DesignPattern;

/*  
    * 싱글톤 패턴. 
    * 싱글톤 패턴은 클래스의 인스턴스를 하나만 생성하고, 그 인스턴스에 대한 전역적인 접근점을 제공하는 디자인 패턴입니다.
    * 싱글톤 패턴을 구현하는 방법은 여러 가지가 있지만, 가장 일반적인 방법은 클래스 내부에 private static 변수를 선언하고, public static 메서드를 통해
    * 그 인스턴스를 반환하는 것입니다. 이렇게 하면 클래스 외부에서 인스턴스를 직접 생성할 수 없고, 항상 동일한 인스턴스를 사용하게 됩니다.
    * 
    * 싱글톤 패턴의 장점:
    * 1. 인스턴스가 하나만 존재하므로 메모리 사용을 절약할 수 있습니다.
    * 2. 전역적인 접근점을 제공하므로 여러 곳에서 동일한 인스턴스를 사용할 수 있습니다.
    * 3. 상태를 공유할 수 있어, 설정이나 리소스를 관리하는 데 유용합니다.
    * 
    * 싱글톤 패턴의 단점:
    * 1. 멀티스레딩 환경에서 동기화 문제를 고려해야 합니다. 여러 스레드가 동시에 인스턴스를 생성하려고 하면 문제가 발생할 수 있습니다.
    * 2. 테스트하기 어려울 수 있습니다. 싱글톤 인스턴스가 전역적으로 존재하므로, 단위 테스트에서 상태를 초기화하거나 독립적으로 테스트하기 어려울 수 있습니다.
    * -> TDD할때 걸림돌이 될수 있음, TDD의 경우 단위 테스트를 주로 하는데, 단위 테스트는 테스트가 서로 독립적이어야 하며 테스트를 어떤 순서로든 실행할 수 있어야 합니다. 
    * -> 하지만 싱글톤 패턴은 미리 생성된 하나의 인스턴스를 기반으로 구현하는 패턴이므로 각 테스트마다 '독립적인' 인스턴스를 만들기가 어렵습니다.
    * 
    * 
    * 
    * 의존성 주입.
    * 싱글톤 패턴은 사용하기가 쉽고 굉장히 실용적이지만 모듈 간의 결합을 강하게 만들 수 있다는 단점이 존재. 이때 의존성 주입(DI)를 통해 모듈간의 결합을 조금 더 느슨하게 만들어 해결할 수 있음. 
        * 의존성이란?
        * 종속성이라고도 하며, A가 B에 의존성이 있다는 것은 B의 변경사항에 따라 A도 변해야 된다는 것을 의미.
    * 메인 모듈이 직접 다른 하위 모듈에 대한 의존성을 주기보다는 중간에 의존성 주입자(dependency injector)가 이 부분을 가초채 메인 모듈이 '간접'적으로 의존성을 주입하는 방식입니다. 
    * 이를 통해 메인 모듈(상위 모듈)은 하위 모듈에 대한 의존성이 떨어지게 됩니다.(디커플링이 된다)라고도 함.
    * 
    * 의존성 주입의 장점:
    * 모듈들을 쉽게 교체할 수 있는 구조가 되어 테스팅하기 쉽고 마이그레이션하기도 수월합니다.
    * 
    * 의존성 주입의 단점:
    * 모듈들이 더욱더 분리되므로 클래스 수가 늘어나 복잡성이 증가될 수 있으며 약간의 런타임 패널티가 생기기도 합니다.
    * 
    * 의존성 주입의 원칙:
    * 의존성 주입은 "상위 모듈은 하위 모듈에서 어떠한 것도 가져오지 않아야 합니다. 또한 둘다 추상화에 의존해야 하며, 이때 추상화는 세부 사항에 의존하지 말아야 합니다."라는 원칙을 따릅니다.
    * 
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

