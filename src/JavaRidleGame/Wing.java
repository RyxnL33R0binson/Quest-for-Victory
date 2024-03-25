package JavaRidleGame;

import java.util.ArrayList;


public class Wing extends Force 
{
    private ArrayList <BattleType> battleTypeList = new ArrayList<BattleType>();
    
    
    public Wing(String ref, String nme, int fee, int strength,int strike)
    {
        super(ref, nme, fee, strength*strike);
        battleTypeList.add(BattleType.SKIRMISH);
        battleTypeList.add(BattleType.AMBUSH);
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
                type = type + temp.toString()+ "\n";
            }
        
        return ss + type;
    }
    


        
}