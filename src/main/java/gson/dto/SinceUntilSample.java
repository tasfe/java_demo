package gson.dto;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class SinceUntilSample {
    /**
     * 设置版本过滤
     *  since 小于版本的field 可序列化与反序列化
     *  unit 大于版本的field 可序列化与反序列化
     */

    @Since(4)
    public String since;
    @Until(5)
    public String until;

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }
}
