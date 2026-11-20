package Chap1_DesignPattern;

/*
    * 팩토리 패턴.
    * 팩토리 패턴은 객체를 사용하는 코드에서 객체 생성 부분을 때어내 추상화한 패턴이자 상속 관계에 있는 두 클래스에서 상위 클래스가 중요한 뼈대를 결정하고, 
    * 하위 클래스가 객체 생성에 관한 구체적인 내용을 결정하는 패턴입니다.
    * 상위 클래스와 하위 클래스가 분리되기 때문에 느슨한 결합을 가지며 상위 클래스에서는 인스턴스 생성 방식에 대해 전혀 알 필요가 없기 때문에 더 많은 유연성을 갖게 됩니다. 
    * 그리고 객체 생성 로직이 따로 떼어져 있기 때문에 코드를 리팩터링하더라도 한 곳만 고칠 수 있게 되니 유지 보수성이 증가됩니다. 
    * 예를 들어 라떼 레시피와 아메리카노 레시피, 우유 레시피라는 구체적인 내용이 들어 있는 하위 클래스가 컨베이어 벨트를 통해 전달되고, 상위 클래스인 바리스타 공장에서 이 레시피들을 토대로 우유등을 생한 하는 공정을 생각하면 이해가 쉽습니다.
*/

enum CoffeeType {
    LATTE, EXPRESSO
}

abstract class Coffee {
    protected String name;

    public String getName() {
        return name;
    }
}

class Latte extends Coffee {
    public Latte() {
        this.name = "Latte";
    }
}

class Expresso extends Coffee {
    public Expresso() {
        this.name = "Expresso";
    }
}

class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case LATTE:
                return new Latte();
            case EXPRESSO:
                return new Expresso();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }
}

public class FactoryTest {
    public static void main(String[] args){
        Coffee coffee = CoffeeFactory.createCoffee(CoffeeType.LATTE);
        System.out.println("Coffee name: " + coffee.getName());

        Coffee coffee2 = CoffeeFactory.createCoffee(CoffeeType.EXPRESSO);
        System.out.println("Coffee name: " + coffee2.getName());


    }
}
