package filter_upgrade;

import io.Request;
import io.Response;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class LoginFilter implements Filter {

//    【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】

    /**
     * @param request
     * @param response
     * @param filterChain
     * @return 【true 通过 继续责任链】/【false 不通过 结束责任链】
     */
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("LoginFilter request处理");

        if (true) {
//            return false;//有意义
        }

        filterChain.doFilter(request, response);

        System.out.println("LoginFilter response处理");

        return true;// 无意义
    }
}
