package servlet;

import io.Request;
import io.Response;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class DemoServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        response.write("Demo DoGet");
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        response.write("Demo DoPost");
    }
}
