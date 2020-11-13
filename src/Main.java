import java.io.IOException;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Main {
    public static void main(String[] args) {
        try {
            // 裸的tomcat
            // 加一个过滤器的逻辑
            // spring mvc
            Server.startServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}