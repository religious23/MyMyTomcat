package filter;

import io.Request;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class MyFilter implements Filter{

    @Override
    public boolean doFilter(Request request) {
        System.out.println("我的过滤器-处理私人逻辑");

        return true;
    }
}
