package annotation;

import java.lang.annotation.*;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
public @interface Autowired {
    String value() default "";
}
