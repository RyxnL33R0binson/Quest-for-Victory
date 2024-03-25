package JavaRidleGame; 
import java.io.*;

public enum BattleType implements Serializable
{
    SKIRMISH ("Skirmish"), AMBUSH("Ambush"), FIGHT("Fight") ;
    private String type;
    
    private BattleType(String ty)
    {
        type = ty;
    }
    
    public String toString()
    {
        return type;
    }
}
