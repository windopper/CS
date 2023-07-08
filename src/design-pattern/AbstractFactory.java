public class AbstractFactory {
    public static void main(String[] args) {

    }
}

interface RoleFactory {
    Role selectGlacial();
    Role selectFlame();
}

class WarriorFactory implements RoleFactory {
    @Override
    public Warrior selectGlacial() {
        return new GlacialWarrior();
    }

    @Override
    public Warrior selectFlame() {
        return new FlameWarrior();
    }
}

class WizardFactory implements RoleFactory {
    @Override
    public Wizard selectGlacial() {
        return new GlacialWizard();
    }

    @Override
    public Wizard selectFlame() {
        return new FlameWizard();
    }
}

interface Role {
    void attack();
}

interface Warrior extends Role {
    void attack();
}

class GlacialWarrior implements Warrior {
    @Override
    public void attack() {
        
    }
}

class FlameWarrior implements Warrior {
    @Override
    public void attack() {
        
    }
}

interface Wizard extends Role {
    void attack();
}

class GlacialWizard implements Wizard {
    @Override
    public void attack() {
        
    }
}

class FlameWizard implements Wizard {
    @Override
    public void attack() {

    };
}