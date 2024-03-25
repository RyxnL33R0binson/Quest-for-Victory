package JavaRidleGame;

import java.util.*;

/**
 *
 * @author rcran
 */
public class Warbird extends Force 
{
   private ArrayList <BattleType> battleTypeList = new ArrayList<BattleType>();
   private boolean cloaking;
   


   public Warbird (String ref, String nme, int fee, int stren, boolean clk)
   {
       super(ref, nme, fee, stren);
       
       battleTypeList.add(BattleType.FIGHT);
       
       setPrice(clk);
   }
   
   private void setPrice(boolean clk)
   {
       if(clk == true)
       {
           setActivationFee(400);
           battleTypeList.add(BattleType.AMBUSH);
       }
       else
       {
           setActivationFee(300);
       }
   }
   
   public boolean hasCloak()
   {
       return cloaking;
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
