import config.StartUpData;

public class Main {
    public static void main(String[] args) {
        loadUpData();

    }
    public static void loadUpData(){
        StartUpData startUpData = new StartUpData();
        startUpData.run();
    }

}