public class ProxyPattern {
    public static void main(String[] args) {
        ThirdPartyYoutubeClass aYouTubeService = new ThirdPartyYoutubeClass();
        CachedYouTubeClass aYouTubeProxy = new CachedYouTubeClass(aYouTubeService);
        YouTubeManager manager = new YouTubeManager(aYouTubeProxy);
        manager.reactOnUserInput();
    }
}

interface ThirdPartyYoutubeLib {
    Object listVideos();
    Object getVideoInfo(int id);
    void downloadVideo(int id);
}

// 서비스 연결자의 구상 구현
// 이 클래스의 메서드들은 유튜브에서 정보를 요청할 수 있다
// 해당 요청의 속도는 사용자와 유튜브의 인터넷 연결 속도에 따라 다를 것이다
// 앱이 많은 요청을 동시에 처리하면 속도가 느려질 것이다
// 이는 요청들이 모두 같은 정보를 요청하더라도 마찬가지다
class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {
    @Override
    public Object listVideos() {
        // 유튜브에 API 요청을 보냄
        return null;
    }

    @Override
    public Object getVideoInfo(int id) {
        // 어떤 비디오에 대한 메타데이터를 가져옴
        return null;
    }

    @Override
    public void downloadVideo(int id) {
        // 유튜브에서 동영상 파일을 다운로드한다.
    }
}

// 일부 대역폭을 절약하기 위해 요청 결과를 캐시하고 일정 기간 보관할 수 있다
// 그러나 이러한 코드를 서비스 클래스에 직접 넣는 것은 불가능할 수 있다
// 예를 들어, 타사 라이브러리의 일부로 제공되었거나 'final'로 정의된 경우에는 그렇다
// 서비스 클래스와 같은 인터페이스를 구현하는 새 프록시 클래스에 캐싱 코드를 넣는 이유가 
// 바로 그것이다
// 이 클래스는 실제 요청을 보내야 하는 경우에만 서비스 객체에 위임한다
class CachedYouTubeClass implements ThirdPartyYoutubeLib {
    private ThirdPartyYoutubeLib service;
    private Object listCache, videoCache;
    boolean needReset;

    public CachedYouTubeClass(ThirdPartyYoutubeLib service) {
        this.service = service;
    }

    @Override
    public Object listVideos() {
        if(listCache == null || needReset)
            listCache = service.listVideos();
        return listCache;
    }

    @Override
    public Object getVideoInfo(int id) {
        if(videoCache == null || needReset)
            videoCache = service.getVideoInfo(id);
        return videoCache;
    }

    @Override
    public void downloadVideo(int id) {
        if(!downloadExists(id) || needReset)
            service.downloadVideo(id);
    }

    private boolean downloadExists(int id) {
        return false;
    }
}

// 서비스 객체와 직접 작업하던 그래픽 사용자 인터페이스 클래스는 서비스 객체와
// 인터페이스를 통해 작업하는 한 변경되지 않는다.
// 둘 다 같은 인터페이스를 구현하므로 실제 서비스 객체 대신 프록시 객체를 안전하게 전달할 수 있다
class YouTubeManager {
    protected ThirdPartyYoutubeLib service;

    public YouTubeManager(ThirdPartyYoutubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(int id) {
        info = service.getVideoInfo(id);
        // 비디오 페이지 렌더링
    }

    public void renderListPanel() {
        list = service.listVideos();
        // 비디오 섬네일 리스트를 렌더링
    }

    public void reactOnUserInput() {
        renderVideoPage(1);
        renderListPanel();
    }
}