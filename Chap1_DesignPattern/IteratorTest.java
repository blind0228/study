package Chap1_DesignPattern;
/*
    * 이터레이터 패턴.
    * 이터레이터 패턴은 컬렉션(리스트, 배열 등)의 요소들을 순차적으로 접근할 수 있는 방법을 제공하는 디자인 패턴입니다.
    * 이터레이터 패턴을 사용하면 컬렉션의 내부 구조를 노출하지 않고도 요소들을 순회할 수 있으며, 다양한 컬렉션 타입에 대해 일관된 방식으로 접근할 수 있습니다.
    * 
    * 이터레이터 패턴의 주요 구성 요소:
    * 1. Iterator 인터페이스: 컬렉션의 요소를 순회하는데 필요한 메서드를 정의합니다. 일반적으로 hasNext()와 next() 메서드를 포함
    * 2. Concrete Iterator 클래스: Iterator 인터페이스를 구현하며, 실제로 컬렉션의 요소를 순회하는 로직을 포함합니다.
    * 3. Aggregate 인터페이스: 컬렉션을 나타내며, Iterator를 생성하는 메서드를 정의합니다.
    * 4. Concrete Aggregate 클래스: Aggregate 인터페이스를 구현하며, 실제로 컬렉션을 나타내고 Iterator를 생성하는 메서드를 포함합니다.
    * 
    * 이터레이터 패턴의 장점:
    * 1. 컬렉션의 내부 구조를 노출하지 않고도 요소들을 순회할 수 있습니다.
    * 2. 다양한 컬렉션 타입에 대해 일관된 방식으로 접근할 수 있습니다.
    * 3. 컬렉션의 순회 로직을 별도의 Iterator 클래스로 분리하여 코드의 재사용성과 유지보수성을 향상시킬 수 있습니다.
    * 
    * 이터레이터 패턴의 단점:
    * 1. Iterator 클래스를 별도로 구현해야 하므로 코드가 다소 복잡해질 수 있습니다.
    * 2. 컬렉션의 크기가 큰 경우, Iterator를 사용하여 순회하는 동안 성능 저하가 발생할 수 있습니다.
    * 3. Iterator를 사용하여 순회하는 동안 컬렉션이 변경되면 ConcurrentModificationException이 발생할 수 있습니다.
*/

import java.util.List;

interface Iterator {
    boolean hasNext();
    Object next();
    

}

class ConcreteIterator implements Iterator {
    private List<Object> collection;
    private int currentIndex = 0;

    public ConcreteIterator(List<Object> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < collection.size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements in the collection.");
        }
        return collection.get(currentIndex++);
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        List<Object> collection = List.of("A", "B", "C", "D", "E");
        Iterator iterator = new ConcreteIterator(collection);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
