public class BridgePattern {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl remote = new RemoteControl(tv);
        remote.togglePower();

        Radio radio = new Radio();
        remote = new AdvancedRemoteControl(radio);
        remote.mute();
    }
}

// '추상화'는 두 클래스 계층 구조의 '제어' 부분에 대한 인터페이스를 정의하며
// 이것은 '구현' 계층 구조의 객체에 대한 참조를 유지하고 모든 실제 작업을
// 이 객체에 위임합니다
class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        }
        else {
            device.enable();
        }
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }
    
    void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}

// 추상화 계층 구조로부터 클래스를 장치 클래스들과 독립적으로 확장할 수 있다.
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    void mute() {
        device.setVolume(0);
    }
}

// '구현' 인터페이스는 모든 구상 구현 클래스들에 공통적인 메서드를 선언하며,
// 이는 추상화의 인터페이스와 일치할 필요가 없다. 실제로 두 인터페이스는 완전히 다를 수 있다.
// 일반적으로 구현 인터페이스는 원시 작업들만 제공하는 반면
// 추상화는 이러한 원시 작업들을 기반으로 더 상위 수준의 작업들을 정의한다
interface Device {
    bool isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}

class TV implements Device {

}

class Radio implements Device {
    
}