package filter;

import io.Request;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class LoginFilter implements Filter{

//    【true 完成过滤 结束责任链】 【false 继续过滤 继续责任链】

    @Override
    public boolean doFilter(Request request) {
        System.out.println("登录过滤器-筛选了一大批人");

        // false -1
        return true;
    }
}
