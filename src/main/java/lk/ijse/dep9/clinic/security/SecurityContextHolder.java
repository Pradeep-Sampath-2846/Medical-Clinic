package lk.ijse.dep9.clinic.security;

public class SecurityContextHolder {

    private static User user;

    public static void setPrincipal(User user){
        if (user==null){
            throw  new NullPointerException("Principal cannot be Null");
        } else if (user.getUsername()==null || user.getUsername().isBlank() || user.getRole()==null) {
            throw new RuntimeException("Invalid user");
        }

        SecurityContextHolder.user=user;

    }

    public static User getPrincipal(){
        if (user==null){
            throw new RuntimeException("No Principal user");
        }
        return user;

    }

    public void clear(){

        user=null;

    }
}
