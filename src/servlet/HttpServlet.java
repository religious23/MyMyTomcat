package servlet;

import io.Request;
import io.Response;

import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public abstract class HttpServlet implements Servlet {

    public abstract void doGet(Request request, Response response) throws IOException;

    public abstract void doPost(Request request, Response response) throws IOException;


    public void service(Request request, Response response) throws IOException {

        if (METHOD_GET.equals(request.getRequestMethod())) {
            doGet(request, response);
        }

        if (METHOD_POST.equals(request.getRequestMethod())) {
            doPost(request, response);
        }

    }
}
