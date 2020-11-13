package servlet.spring;

import annotation.Component;

import java.util.HashMap;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
@Component
public class MapperService {
    public void autowired(){
        System.out.println("我是自动注入的方法，看看能否实现！");
    }
}
