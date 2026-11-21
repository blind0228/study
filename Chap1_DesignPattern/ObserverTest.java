package Chap1_DesignPattern;

import java.util.ArrayList;
import java.util.List;

/*
    * 옵저버 패턴.
    * 옵저버 패턴은 주체가 어떤 객체(Subject)의 상태 변화를 관찰하다가 상태 변화가 있을 때마다 메서드 등을 통해 옵저버 목록에 있는 옵저버들에게 변화를 알려주는 디자인 패턴.
    * 옵저버 패턴을 활용한 서비스로는 트위터(Twitter)와 페이스북(Facebook) 등이 있으며, 트위터의 팔로우 기능과 페이스북의 친구 기능이 옵저버 패턴을 활용한 대표적인 예시.
    * 또한 옵저버 패턴은 주로 이벤트 기반 시스템에 사용하며 MVC(Model-View-Controller) 패턴에도 사용됩니다.
    * 예를 들어 주체라고 볼 수 있는 모델에서 변경 사항이 생겨 update() 메서드로 옵저버인 뷰에 알려주고 이를 기반으로 컨트롤로(Controller)가 뷰를 업데이트하는 방식으로 동작합니다.
    * 
    * 상속.(extends)
    * 자식 클래스가 부모 클래스이 메서드 등을 상속받아 사용하며 자식 클래스에서 추가 및 확장 할 수 있는 것을 말합니다. 이로 인해 재사용성, 중복성의 최소화가 이루어짐.
    * 
    * 구현.(implements)
    * 부모 인터페이스를 자식 클래스에서 재정의하여 구현하는 것을 말하며, 상속과는 달리 반드시 부모 클래스의 메메서드를 재정의하여 구현해야 합니다. 
    * 
    * 상속과 구현의 차이
    * 상속은 일반 클래스, abstract 클래스를 기반으로 구현하며, 구현은 인터페이스를 기반으로 구현합니다.
    * 
*/

interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
    public Object getUpdate(Observer o);
}

interface Observer {
    void update();
}

class Topic implements Subject {
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override 
    public void registerObserver(Observer o) {
        if(!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override 
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override 
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }

    public Object getUpdate(Observer o) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message posted to topic: " + msg);
        this.message = msg;
        notifyObservers();
    }
}

class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null) {
            System.out.println(name + " No new message");
        } else {
            System.out.println(name + " received message: " + msg);
        }

    }

}

public class ObserverTest {
    public static void main(String[] args) {
        Topic topic = new Topic();

        Observer observer1 = new TopicSubscriber("Observer 1", topic);
        Observer observer2 = new TopicSubscriber("Observer 2", topic);
        Observer observer3 = new TopicSubscriber("Observer 3", topic);

        topic.registerObserver(observer1);
        topic.registerObserver(observer2);
        topic.registerObserver(observer3);

        topic.postMessage("Hello, Observers!");
    }
}
