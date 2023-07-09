public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();

        int a = 5;
        int b = 10;

        context.setStrategy(new ConcreteStrategyAdd());
        System.out.println(context.executeStrategy(a, b));
    }
}

// 전략 인터페이스는 어떤 알고리즘의 모든 지원 버전에 공통적인 작업을 선언한다.
// 콘텍스트는 이 인터페이스를 사용하여 구상 전략들에 의해 정의된 알고리즘을 호출한다.
interface Strategy {
    int execute(int a, int b);
}

class ConcreteStrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class ConcreteStrategySubtract implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

class Context {
    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
