package gson.dto;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class DataDTO<T> {
    T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
