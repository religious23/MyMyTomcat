package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 王文
 * @date 2020/11/13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Request {

    private String requestMethod;

    private String requestUrl;

    public Request(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[32];

        int len = 0;

        String str = "";

        if ((len = inputStream.read(buffer)) > 0 ){
            str = new String(buffer,0,len);
        }

        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
