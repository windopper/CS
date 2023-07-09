import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        List<Shape> allShapes = new ArrayList<>();

        XMLExportVisitor exportVisitor = new XMLExportVisitor();

        for(Shape shape : allShapes) {
            shape.accept(exportVisitor);
        }
    }
}

// 요소 인터페이스는 기초 방문자 인터페이스를 인수로 받는 'accept' 메서드를 선언한다.
interface Shape {
    void move(int x, int y);
    void draw();
    void accept(Visitor v);
}

// 각 구상 요소 클래스는 요소의 클래스에 해당하는 비지터의 메서드를 호출하는 방식으로
// 'accept' 메서드를 구현해야 한다.
class Dot implements Shape {

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    // 참고로 우리는 현재 클래스 이름과 일치하는 'visitDot'를 호출하고 있다
    // 그래야 비지터가 함께 작업하는 요소의 클래스를 알 수 있다
    @Override
    public void accept(Visitor v) {
        v.visitDot(this);
    }
}

class Circle implements Shape {

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void accept(Visitor v) {
        v.visitCircle(this);
    }
}

class Rectangle implements Shape {

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
}

class CompoundShape implements Shape {

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void accept(Visitor v) {
        v.visitCompoundShape(this);
    }
}

// 비지터 인터페이스는 요소 클래스들에 해당하는 방문 메서드들의 집합을 선언한다
// 방문 메서드의 시그니처를 통해 비지터는 처리 중인 요소의 정확한 클래스를 식별할 수 있다
interface Visitor {
    void visitDot(Dot d);
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
    void visitCompoundShape(CompoundShape cs);
}

class XMLExportVisitor implements Visitor {

    @Override
    public void visitDot(Dot d) {

    }

    @Override
    public void visitCircle(Circle c) {

    }

    @Override
    public void visitRectangle(Rectangle r) {

    }

    @Override
    public void visitCompoundShape(CompoundShape cs) {

    }

}
