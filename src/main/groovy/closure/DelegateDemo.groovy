package closure

/**
 * Created by zhdxu on 2017/8/16.
 */
class DelegateDemo {

    String name;
    Map<String, Closure> resultHandlers = new HashMap<>();


    Map<String, Closure> getResult() {
        return this.resultHandlers;
    }
}
