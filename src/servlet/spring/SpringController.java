package servlet.spring;

import annotation.Autowired;
import annotation.Component;
import annotation.RequestMapping;
import io.Request;
import io.Response;
import servlet.HttpServlet;

import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
@Component
@RequestMapping("spring")
public class SpringController {

    @Autowired
    private MapperService mapperService;

    @RequestMapping("test")
    public String test() {
        System.out.println("I am Spring Test!!!");

        mapperService.autowired();

        return "I am Spring Test Response!!!";
    }
}
