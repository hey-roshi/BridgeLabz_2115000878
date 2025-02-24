import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AccessControl {

    @RoleAllowed("ADMIN")
    public void adminMethod() {
        System.out.println("Access granted to the admin method.");
    }

    @RoleAllowed("USER")
    public void userMethod() {
        System.out.println("Access granted to the user method.");
    }

    public void checkAccess(String role, String methodName) {
        try {
            Method method = getClass().getDeclaredMethod(methodName);
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed != null && role.equals(roleAllowed.value())) {
                method.invoke(this);
            } else {
                System.out.println("Access Denied!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class RoleBasedAccessControl {

    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();

        // Testing access control with different roles and methods
        accessControl.checkAccess("ADMIN", "adminMethod");
        accessControl.checkAccess("USER", "adminMethod");
    }
}