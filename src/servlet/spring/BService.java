package servlet.spring;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
@Component
@RequestMapping("loop")
public class BService {

    @Autowired
    private AService aService;

    @RequestMapping("b_test")
    public String bTest() {
        System.out.println("我是 BService 的方法,将要调用 A");
        aService.a();

        return "BService over";
    }

    public void b() {
        System.out.println("我是 BService 的方法 b");
    }
}
