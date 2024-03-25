package JavaRidleGame;

import java.util.ArrayList;

public class Starship extends Force 
{
    private ArrayList <BattleType> battleTypeList = new ArrayList<BattleType>();
    private int cannon;
    private int photon;

       
    public Starship (String ref, String nme, int fee, int stren,int can, int photon)
    {
        super(ref, nme, fee, stren);
        battleTypeList.add(BattleType.SKIRMISH);
        battleTypeList.add(BattleType.FIGHT);
        photon = photon;
        
        setActivationFee(can*30);
        
        setStrength(photon, can);
    }

    
    private void setStrength(int photon, int can)
    {
        int strength;
        int phot = photon * 5;
        int cann = can * 10;
        
        strength = phot + cann;
        setBattleStrength(strength);
    }

    public int getCannon()
    {
        return cannon;
    }
    
    public int getPhonton()
    {
        return photon;
    }
    
    public ArrayList<BattleType> getBattleTypes()
    {
        return battleTypeList;
    }
    

    public String toString()
    {
        String ss = "";
        String type = ""; 
        
        ss = ss + super.toString() + "\nBattle Types: ";
                
            for(BattleType temp : battleTypeList)
            {
                type = type + temp.toString() + "\n";
            }
        
        return ss + type;
    }
}
