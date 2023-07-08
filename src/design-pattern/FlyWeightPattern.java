import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeightPattern {
    public static void main(String[] args) {

    }
}

// 고유한 상태
class Tree {
    double x, y;
    TreeType treeType;

    public Tree(double x, double y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    void draw() {
        treeType.draw();
    }
}

// 공유한 상태
class TreeType {
    String name;
    String color;
    String texture;
    
    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    void draw() {

    }
}

class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(name, result);
        }

        return result;
    }
}

class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }
}



