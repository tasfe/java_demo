package gson.dto;

/**
 * Created by zhdxu on 2017/8/15.
 */
public class ModifierSample {

    /**
     * 基于修饰符进行过滤
     */


    final String finalField = "final";
    static String staticField = "static";
    public String publicField;
    private String privateField;
    protected String protectedField;
    String defaultField;

    public String getFinalField() {
        return finalField;
    }

    public static String getStaticField() {
        return staticField;
    }

    public static void setStaticField(String staticField) {
        ModifierSample.staticField = staticField;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    public String getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }


}
