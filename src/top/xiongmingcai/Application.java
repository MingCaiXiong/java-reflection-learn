package top.xiongmingcai;


import top.xiongmingcai.i18n.I18N;

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

            I18N i18N = (I18N) Class.forName(language).newInstance();

            String say = i18N.say();
            System.out.println("say = " + say);//say = 生命不息 奋斗不止!
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Application.start();
    }
}
