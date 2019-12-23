package utilities;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class LoadProperties {
    public static String saveQueryfile = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "propertiesFiles" + File.separator + "test_data.properties";

    public static String getValueFromPropertyFile(String fileName, String key) {
        String value = "";
        try {
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\propertiesFiles\\" + fileName + ".properties";
            FileInputStream fin = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fin);
            value = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return value;
    }

    public static void storeInSaveTestDataFile(String key, String vendorEmail) throws org.apache.commons.configuration.ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration(saveQueryfile);
        properties.setProperty(key, vendorEmail);
        properties.save();
    }
    public static void setRuntimeDataInPropertyFile(String fileName, Map<String, String> map) {
        try {
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\propertiesFiles\\" + fileName + ".properties";
            FileOutputStream fout = new FileOutputStream(path);
            Properties properties = new Properties();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(fout, "Adding runtime date in file");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
