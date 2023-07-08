import java.util.List;

public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        ItemBuilder builder = new ItemBuilder();
        director.constructCommonNecklace(builder);
        Item item = builder.getResult();
    }
}

class Item {
    private String itemName;
    private ItemType itemType;
    private List<String> itemLore;
    private Damage itemDamage;

    public Item(String itemName, ItemType itemType, List<String> itemLore, Damage itemDamage) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemLore = itemLore;
        this.itemDamage = itemDamage;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public List<String> getItemLore() {
        return itemLore;
    }

    public Damage getItemDamage() {
        return itemDamage;
    }
}

interface Builder {
    void setItemName(String name);
    void setItemType(ItemType type);
    void setItemLore(List<String> lores);
    void setDamage(Damage damage);
}

class ItemBuilder implements Builder {
    private String itemName;
    private ItemType itemType;
    private List<String> itemLore;
    private Damage itemDamage;

    @Override
    public void setItemName(String name) {
        this.itemName = name;
    }

    @Override
    public void setItemType(ItemType type) {
        this.itemType = type;
    }

    @Override
    public void setItemLore(List<String> lores) {
        this.itemLore = lores;
    }

    @Override
    public void setDamage(Damage damage) {
        this.itemDamage = damage;
    }

    public Item getResult() {
        return new Item(itemName, itemType, itemLore, itemDamage);
    }
}

enum ItemType {
    Necklace,
    Ring,
    Bracelet;
}

class Damage {
    int min;
    int max;

    public Damage(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

class Director {
    public void constructCommonNecklace(Builder builder) {
        builder.setItemName("Common Necklace");
        builder.setItemLore(List.of(
            "This is common Necklace",
            "",
            "")
        );
        builder.setDamage(new Damage(0, 100));
    }
}



