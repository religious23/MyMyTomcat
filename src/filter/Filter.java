package filter;

import io.Request;
import io.Response;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public interface Filter {
    /**
     *
     * @param request
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    boolean doFilter(Request request);
}

