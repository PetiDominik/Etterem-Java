
package etterem;


public enum TableNames {

    RED("piros"),
    GREEN("zöld"),
    BLUE("kék"),
    WHITE("fehér");
    
    public final String displayName;
    
    private TableNames(String displayName) {
        this.displayName = displayName;
    }
    
}
