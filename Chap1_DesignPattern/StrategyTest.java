package Chap1_DesignPattern;

import java.util.ArrayList;
import java.util.List;

/*
    * 전략 패턴.
    * 전략 패턴은 정책 패턴(Policy Pattern)이라고도 하며, 객체의 행위를 바꾸고 싶을 경우 '직접' 수정하지 않고 전략이라고 부르는 '캡슐화한 알고리즘'을 
    * 컨텍스트 안에서 바꿔주면 상호 교체가 가능하게 만드는 패턴
    * 
    * passport 라이브러리.
    * Node.js에서 인증 모듈로 구현할 때 쓰는 미들웨어 라이브러리로, 여러 가지 '전략'을 기반으로 인증할 수 있게 합니다.
    * 서비스 내의 회원가입된 아이디와 비밀번호를 기반으로 인증하는 LocalStrategy 전략과 페이스북, 네이버 등 다른 서비스를 기반으로 인증하는 OAuth 전략 등을 지원.
 */

interface PaymentStrategy {
    void pay(int amount);
}

class KAKAOCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KAKAOCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override 
    public void pay(int amount) {
        System.out.println(amount + " paid with KAKAO Card");
    }
}

class LUNACardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public LUNACardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with LUNA Card");
    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int cost) {
        this.name = name;
        this.price = cost;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}



public class StrategyTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        // pay by KAKAO card
        cart.pay(new KAKAOCardStrategy("KAKAO", "1234567890123456", "786", "12/15"));

        // pay by LUNA card
        cart.pay(new LUNACardStrategy("LUNA", "9876543210987654", "123", "11/14"));
    }
}
