import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {

    }
}

// 컴포넌트 인터페이스는 합성 관계의 단순 객체와 복잡한 객체 모두를 위한
// 공통 작업들을 선언한다
interface Graphic {
    void move(int x, int y);
    void draw();
}

// 잎 클래스는 합성 관계의 최종 객체를 나타낸다.
// 잎 객체는 하위 객체를 가질 수 없다
// 일반적으로 작업을 수행하는 것은 잎 객체들이며, 복합체 객체들은
// 오로지 자신의 하위 컴포넌트에만 작업을 위임한다
class Dot implements Graphic {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        // x와 y에 점을 그린다
    }
}

// 모든 컴포넌트 클래스들은 다른 컴포넌트들을 확장할 수 있다
class Circle extends Dot {

    double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        // x와 y에 반지름이 radius인 원을 그린다
    }
}

// 복합체 클래스는 자식이 있을 수 있는 복잡한 컴포넌트들을 나타낸다.
// 복합체 객체들은 일반적으로 실제 작업을 자식들에 위임한 다음 결과를 '합산'한다
class CompoundGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic child) {
        children.add(child);
    }

    public void remove(Graphic child) {
        children.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for(Graphic child : children) {
            child.move(x, y);
        }
    }

    // 복합체는 특정 방식으로 기본 논리를 실행한다
    // 복합체는 모든 자식을 재귀적으로 순회하여 결과들을 수집하고 요약한다
    // 복합체의 자식들이 이러한 호출들을 자신의 자식들 등으로 전달하기 때문에
    // 결과적으로 전체 객체 트리를 순회하게 된다
    @Override
    public void draw() {
        
    }
}


