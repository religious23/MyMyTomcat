package servlet.spring;

import annotation.Component;
import annotation.RequestMapping;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
@Component
@RequestMapping("lifecycle")
public class LifeCycleController {

    @RequestMapping("test")
    public String test(){
        System.out.println("lifecycle test");

        return "lifecycle test over";
    }
}
