package filter_upgrade;

import io.Request;
import io.Response;

import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class MyFilter implements Filter {

    /**
     * @param request
     * @param response
     * @param filterChain
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        try {
            System.out.println("MyFilter request处理(前置处理)");
            response.write("MyFilter request1");

            filterChain.doFilter(request, response);

            System.out.println("MyFilter response处理(后置处理)");
            response.write("MyFilter response2");

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
