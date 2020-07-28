package br.com.leodevel.quarkusbasicproject.enums;

public enum RoleEnum {
	
	ROLE_USER(Names.ROLE_USER), 
	ROLE_ADMIN(Names.ROLE_ADMIN);
	
	public class Names {
        public static final String ROLE_USER = "ROLE_USER";
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
    }

    private final String label;

    private RoleEnum(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
	
}
