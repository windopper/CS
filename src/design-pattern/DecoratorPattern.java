public class DecoratorPattern {
    public static void main(String[] args) {
        DataSource file = new FileDataSource("hello world!");
        file = new EncryptionDecorator(new CompressionDecorator(file));

        file.writeData("HIHI");
        file.readData();
    }
}

interface DataSource {
    void writeData(String data);
    String readData();
}

class FileDataSource implements DataSource {
    private String fileName;
    private String data;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        // 1. 파일 쓰기
        System.out.println("Write Data : " + data);
        this.data = data;
    }

    @Override
    public String readData() {
        // 1. 파일 읽기
        System.out.println("Read Data : " + data);
        return this.data;
    }    
}

class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // 1. 전달된 데이터를 암호화
        System.out.println("Encode Data : " + data);
        // 2. 암호화 된 데이터를 wrappee의 writeData 메서드에 전달
        super.writeData(data);
    }

    @Override
    public String readData() {
        // 1. wrappee의 readData 메서드에서 데이터를 가져옴.
        String data = super.readData();
        // 2. 암호화 되어 있다면 암호 해독을 시도해야됨
        System.out.println("Decode Data : " + data);
        // 3. 결과를 반환
        return data;
    }
}

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        // 1. 전달된 데이터를 압축
        System.out.println("Compress Data : " + data);
        // 2. 압축된 데이터를 wrappee의 writeData메서드에 전달
        super.writeData(data);
    }

    @Override
    public String readData() {
        // 1. wrappee의 readData 메서드에서 데이터를 가져옴.
        String data = super.readData();
        // 2. 압축되어 있으면 압축을 품
        System.out.println("Decompress Data : " + data);
        // 3. 결과를 반환
        return data;
    }
}


