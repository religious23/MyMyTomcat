//import filter.FilterChain;

import filter_upgrade.FilterChain;
import io.Request;
import io.Response;
import servlet.Servlet;

import java.io.InputStream;// 磁盘IO
import java.io.OutputStream;// 网络IO BIO --NIO AIO
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Server {

    /**
     * 启动
     */
    public static void startServer(int port) throws Exception {
        // 服务端套接字
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("==== ==== ====");
            Socket socket = serverSocket.accept();
            // 获取输入输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Request request = new Request(inputStream);
            Response response = new Response(outputStream);

            // 执行servlet操作
            String url = request.getRequestUrl();
            String className = Mapping.getClassNameByUrl(url);
            // 这一步 为了测试spring Dispatcher 固定写死 --> 改进 逻辑封装进方法里
//            String className = "servlet.DispatcherServlet";

//        System.out.println(url + "-" + className);// servlet.MyServlet
            if (className != null) {
//                String className = "servlet.DispatcherServlet";
                // 多态
                Class<Servlet> clazz = (Class<Servlet>) Class.forName(className);

                // 根据类创建对象
                Servlet servlet = clazz.newInstance();// MyServlet

//                 执行过滤器操作
                //filterExec(request);
                filterUpgradeExec(servlet, request, response);// 最终版

//                通过过滤器条件来调用service
               // servlet.service(request, response);
            } else {
                // mapping 不存在
                response.write("Route doesn't exist:" + url);
            }

            response.close();
        }
    }

    /**
     * 做过滤器内容
     */
   /* public static void filterExec(Request request) {
        final FilterChain filterChain = new FilterChain();
        filterChain.doFilter(request);
    }*/


    public static void filterUpgradeExec(Servlet servlet, Request request, Response response) {
        final FilterChain filterChain = new FilterChain(servlet);
        //filterChain.doFilter(request, response, filterChain);
        filterChain.doFilter(request, response);
    }

}
