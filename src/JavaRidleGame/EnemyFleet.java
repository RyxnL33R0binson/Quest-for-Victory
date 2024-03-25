package JavaRidleGame;

import java.io.Serializable;

public class EnemyFleet implements Serializable{
   
   private int battleNum;
   private BattleType battleType;
   private String name;
   private int strength;
   private int losses;
   private int gains;
   
   EnemyFleet(int btlno, BattleType typ, String nm, int str, int lss, int gns){
       battleNum = btlno;
       battleType = typ;
       name = nm;
       strength = str;
       losses = lss;
       gains = gns;
   }
   
   @Override
    public String toString() {
        
        String ss = "";
        
        ss = ss + "Name: " + getName() + "\nBattle Number: " + getBattleNo()
                + "\nBattle Type: " + getBattleType() + "\nBattle Strength: "
                + getBattleStrength() + "Gains: " + getGains() + "\nLosses: "
                +getLosses();
        
        return ss;
    }
   // getters
   public int getBattleNo()
   {
      return battleNum;
   }
   public String getName()
   {
      return name;
   }
   public int getBattleStrength()
   {
      return strength;
   }
   public BattleType getBattleType()
   {
     return battleType;
   }
    public int getGains()
    {
      return gains;
    }
    public int getLosses()
    {
      return losses;
    }
}
