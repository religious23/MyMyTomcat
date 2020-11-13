package filter;

import filter.Filter;
import io.Request;
import servlet.Servlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class FilterChain {

    private List<Filter> chain = new LinkedList<Filter>();

    private void add(Filter filter) {
        chain.add(filter);
    }

    public FilterChain() {
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("Filter.properties");
            properties.load(in);

            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                String className = properties.getProperty(key);
//                System.out.println("添加顺序--------" + className);
                Class<Filter> clazz = (Class<Filter>) Class.forName(className);
                // 根据类创建对象
                Filter filter = clazz.newInstance();// MyFilter

                chain.add(filter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doFilter(Request request) {
        for (Filter filter : chain) {
//            【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】
            final boolean pass = filter.doFilter(request);

            if (!pass) {
                break;
            }
        }
    }

}
