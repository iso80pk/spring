package pl.softsystem.wyklad1.config;

public class AuthorizeExpressions {

    public static final String ADMIN = "hasRole('ADMIN')";
    public static final String USER = "hasRole('USER')";
    public static final String USER_OR_ADMIN = "hasRole('USER') or hasRole('ADMIN')";

}
