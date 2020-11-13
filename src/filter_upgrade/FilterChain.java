package filter_upgrade;

import io.Request;
import io.Response;
import servlet.Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class FilterChain {

    // 把过滤器类声明在配置文件里
    // 通过反射依次实例化每个类
    // 用眼下这个List 去 存储好 每一个 过滤器类
    private List<Filter> chain = new LinkedList<Filter>();

    private Integer index = 0;

    private Servlet servlet;

    private void add(Filter filter) {
        chain.add(filter);
    }

    public FilterChain(Servlet servlet) {
        this.servlet = servlet;
        Properties properties = new Properties();// XPath xml
        try {
            InputStream in = new FileInputStream("FilterUpgrade.properties");
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

//    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
//        // 到达尽头
//        if (filterChain.index == filterChain.chain.size()) return false;
//
//        Filter filter = filterChain.chain.get(filterChain.index++);
//
//        return filter.doFilter(request, response, filterChain);
//    }


    // 递归
    public boolean doFilter(Request request, Response response) {
        // List { [],[],[],[]  } 里面有四个过滤器 你要把四个过滤器都执行完 你才能执行service 方法
        // 到达尽头
        if (index == chain.size()) {
            try {
                servlet.service(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;// 返回值无所谓了 结束责任链
        }

        Filter filter = chain.get(index++);

        return filter.doFilter(request, response, this);
    }


}
