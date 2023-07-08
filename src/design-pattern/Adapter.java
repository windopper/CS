public class Adapter {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        System.out.println(hole.fits(rpeg));

        SquarePeg sqreg = new SquarePeg(5);
        SquarePeg lsqreg = new SquarePeg(10);
        // hole.fits(SquarePeg); 호환되지 않음

        SquarePegAdapter sqpeg_adapter = new SquarePegAdapter(sqreg);
        SquarePegAdapter lsqpeg_adapter = new SquarePegAdapter(lsqreg);
        System.out.println(hole.fits(sqpeg_adapter));
        System.out.println(hole.fits(lsqpeg_adapter));
    }
}

class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    boolean fits(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }
}

class RoundPeg {
    private double radius;

    public RoundPeg() {
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return this.width;
    }
}

// RoundPeg 클래스를 확장하여 SquarePeg가 둥근 못 처럼 작동하게 만듬
class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    public double getRadius() {
        return peg.getWidth() * Math.sqrt(2) / 2;
    }
}
