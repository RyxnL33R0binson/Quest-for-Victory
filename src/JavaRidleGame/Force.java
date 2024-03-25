package JavaRidleGame;

import java.io.Serializable;
import java.util.*;


public abstract class Force implements Serializable{

    private String fleetref;
    private String name;
    private int activationfee;
    private int battlestrength;
    
    
    private ForceState forcestate;

    Force(String ref, String nm, int actfee, int btlstr)
    {
       fleetref = ref;
       name = nm;
       activationfee = actfee;
       battlestrength = btlstr;
       forcestate =  ForceState.DOCKED;
    }

    //Setters
    public void setActivationFee(int fee)
    {
       this.activationfee = fee;
    }
    
    public void setBattleStrength(int btlstr)
    {
        this.battlestrength = btlstr;
    }

    public void setForceState(ForceState stt)
    {
        this.forcestate = stt;
    }

    
   //Getters   
    public int getActivationFee()
    {
       return activationfee;
    }
    
    public ForceState getState()
    {
       return forcestate;
    }

    public String getReference()
    {
       return fleetref;
    }

    public String getName()
    {
       return name;
    }

    public int getBattleStrength()
    {
       return battlestrength;
    }
    
    public String toString() 
    {
        String ss = "";
        
        ss = ss + "\nReference: " + getReference()+ "\nName: " + getName() +
                "\nActivation Fee: " + getActivationFee() + "\nBattle Strength: "
                + getBattleStrength() + "\nStatus: " + getState();
        
        return ss;
    }

}

