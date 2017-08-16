package closure

import org.springframework.data.util.ReflectionUtils

/**
 * Created by zhdxu on 2017/8/16.
 */
class ClosureDemo {

    void println(String text, Closure closure) {
        DelegateDemo delegateDemo = new DelegateDemo();
        closure.setDelegate(delegateDemo)
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call(text)
        createResult(delegateDemo)
    }

    Object createResult(DelegateDemo delegateDemo) {
        if(delegateDemo.name == "success")  {
            String resp = "200"
            String json = "success ..."
            delegateDemo.resultHandlers.get(delegateDemo.name).call(resp, json)
        }else {
            String resp = "404"
            delegateDemo.resultHandlers.get(delegateDemo.name).call(resp)
        }

    }
}
