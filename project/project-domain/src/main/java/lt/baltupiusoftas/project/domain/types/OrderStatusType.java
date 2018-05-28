package lt.baltupiusoftas.project.domain.types;

/**
 * Order status type
 *
 * @author Audrius Tvarijonas
 */
public enum OrderStatusType {
    INCOMPLETE ("Nepabaigtas"),
    COMPLETED ("Pabaigtas");

    private final String name;

    private OrderStatusType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
