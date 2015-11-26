package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class FooInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        if (actionInvocation.getAction() instanceof SecureAction) {
            SecureAction action = (SecureAction) actionInvocation.getAction();
            String role = action.requiresRole();
            String userRole = (String) session.get("role");
            if (!role.equals(userRole)) {
                return "login";
            }
        }
        return actionInvocation.invoke();
    }
}
