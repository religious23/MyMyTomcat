import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Mapping {

    private static HashMap<String, String> mapping = new HashMap<String, String>();

    static {
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("Route.properties");
            properties.load(in);

            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                mapping.put(key, properties.getProperty(key));
//                System.out.println(key);
//                System.out.println(properties.getProperty(key));;
//                System.out.println("---------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getClassNameByUrl(String url) {

        // 配且只配 dispatcher 偷个懒 直接写死
        return "servlet.DispatcherServlet";
//        return mapping.get(url);
    }

}
