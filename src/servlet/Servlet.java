package servlet;

import io.Request;
import io.Response;

import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public interface Servlet {

    String METHOD_GET = "GET";
    String METHOD_POST = "POST";

    void service(Request request, Response response) throws IOException;
}
