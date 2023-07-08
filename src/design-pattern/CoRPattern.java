import java.util.ArrayList;
import java.util.List;

public class CoRPattern {
    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.wikiPageURL = "http://...";
        Panel panel = new Panel();
        panel.modalHelpText = "This panel does...";
        Button ok = new Button();
        Button cancel = new Button();
        panel.add(ok);
        panel.add(cancel);
        dialog.add(panel);

        ok.showHelp();
    }
}

// 핸들러 인터페이스
interface ComponentWithContextualHelp {
    void showHelp();
}

// 기초 핸들러
abstract class Component implements ComponentWithContextualHelp {
    String toolTipText;

    protected Container container;

    // 컴포넌트는 도움말 텍스트가 할당되어있을 때 도구 설명을 표시한다.
    // 그렇지 않으면, 컨테이너가 있는 경우 호출을 해당 컨테이너로 전달한다.
    public void showHelp() {
        if (this.toolTipText != null) {
            // 도구 설명 표시
            System.out.println(toolTipText);
        } else {
            container.showHelp();
        }
    }
}

// 컨테이너는 간단한 컴포넌들과 다른 컨테이너들을 자식으로 포함할 수 있다.
// 여기에서 체인 관계가 설립된다. 해당 클래스는 부모로부터 showHelp 행동을 상속한다.
abstract class Container extends Component {
    protected List<Component> children = new ArrayList<>();

    void add(Component child) {
        children.add(child);
        child.container = this;
    }
}

class Button extends Component {

}

class Panel extends Container {
    String modalHelpText;

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            // 도움말 텍스트와 함께 모달 창을 표시한다
            System.out.println(modalHelpText);
        } else {
            super.showHelp();
        }
    }
}

class Dialog extends Container {
    String wikiPageURL;

    @Override
    public void showHelp() {
        if (wikiPageURL != null) {
            // 위키 도움말 페이지를 연다
            System.out.println(wikiPageURL);
        } else {
            super.showHelp();
        }
    }
}
