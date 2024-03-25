package JavaRidleGame; 
import java.io.*;


public interface SWAT extends Serializable 
{
    public String toString();

    public int getWarchest();
    
    public boolean isDefeated();
    
    public boolean isInUFFleet(String ref);

    public String getUFFleet();
        
    public String getForceDetails(String ref);
        
    public int activateForce(String ref);

    public boolean isInASFleet(String ref);
    
    public void recallForce(String ref);
        
    public String getASFleet();
       
    
//**********************Battles************************* 
    public boolean isBattle(int num);

    public String getBattle(int num);
 
    public String getAllBattles();
    
    public int doBattle(int battleNo);
    
    public void saveGame(String fname);
    
    public SpaceWars restoreGame(String fname);
}
