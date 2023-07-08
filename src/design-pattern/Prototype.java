// 프로토타입 패턴

public class Prototype {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        
        Shape rectangle_ = rectangle.clone();
        rectangle_.print();
    }
}

// 프로토타입
abstract class Shape {
    int x;
    int y;
    String color;

    public Shape() {}

    public Shape(Shape source) {
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
    }

    public abstract Shape clone();

    public abstract void print();
}

class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle() {
        super();
    }

    public Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void print() {
        System.out.println("width : " + this.width);
        System.out.println("height : " + this.height);
    }
}