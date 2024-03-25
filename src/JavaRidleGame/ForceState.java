package JavaRidleGame; 
import java.io.*;

public enum ForceState implements Serializable
{
    DOCKED(" In dock"), ACTIVE(" Active"), DESTROYED (" destroyed");
    private String state;
    
    private ForceState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
