package top.xiongmingcai;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class Application {
    public static void start() {
        Properties properties = new Properties();
        String name = "/config.properties";
        String configPath = Application.class.getResource(name).getPath();

        try {
            String decode = URLDecoder.decode(configPath, "UTF-8");
            properties.load(new FileInputStream(decode));
            String language = properties.getProperty("language");

            System.out.println("language = " + language);//language = top.xiongmingcai.i18n.Zhcn
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Application.start();
    }
}
