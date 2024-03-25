package JavaRidleGame; 
import java.util.*;
import java.io.*;


public class SpaceWars implements SWAT,Serializable 
{
   private String name;
   private int warchest;
   private ArrayList <Force> forcesList = new ArrayList<>();
   private ArrayList <EnemyFleet> enemyFleetsList = new ArrayList<>();
   
 
    public SpaceWars(String admiral)
    {
       name = admiral;
       warchest = 1000;
       setupForces();
       setupBattles();
    }
    

    
    public boolean isDefeated()
    {   
        String ss = "";
        boolean noForces = false;
        if(getWarchest() <= 120)
        {
            noForces = true;
            ss = ss + "You do not have enough to recall any forces.";
        }
        
        if(noForces == false)
        {
            ss = ss + "You have enough to recruit: \n";
            for(Force temp : forcesList)
            {
                if(temp.getActivationFee() <= getWarchest())
                {
                    ss = ss + temp.getName()+ "\n";
                }
            }
        }
        return noForces;
    }
        
    public int activateForce(String ref)
    {
        String ss = "";
        for(Force temp : forcesList)
        {
            if(temp.getReference().equals(ref))
            {
                if(temp.getState() != ForceState.DOCKED)
                {
                    ss = ss + "Force is not in the UFF";
                    return 1;
                }
                else if(temp.getActivationFee() > warchest)
                {
                    ss = ss + "You do not have enough money";
                    return 2;
                }
                else
                {
                    temp.setForceState(ForceState.ACTIVE);
                    warchest = warchest - temp.getActivationFee();
                    ss = ss + "Force is now in ASF!";
                    return 0;
                }
            }     
            else
            {
                ss = ss + "No such force";
            }
        }
        return -1;
    }
    

    public boolean isInASFleet(String ref)
    {
        for (Force temp: forcesList)
        {
            if (temp.getReference().equals(ref)){
                if (temp.getState() == ForceState.ACTIVE)
                {
                   return true;
                }   
             }
        }
        return false;
    }
    
  
    public boolean isInUFFleet(String ref) 
    {
        for(Force temp : forcesList)
        {
            if(ref.equals(temp.getReference()) && temp.getState() == ForceState.DOCKED)
            {
                return true;
            }
        }
        return false;    
    }
    
    
    
    public void recallForce(String ref)
    {
        for(Force temp : forcesList)
        {
            if(ref.equals(temp.getReference()))
            {
                if(temp.getState() == ForceState.ACTIVE)
                {
                    temp.setForceState(ForceState.DOCKED);
                    warchest = warchest + temp.getActivationFee();
                }
            }
        }
    }   
      
    
//**********************Battles************************* 

    public boolean isBattle(int num)
    {
        String ss = "";
        for (EnemyFleet temp: enemyFleetsList)
        {
           if (num == temp.getBattleNo())
           {
               ss = ss + temp.toString();
               return true;   
           }
        }
        ss = ss + "Does not exist";
        return false;
    }
     
     
    public int doBattle(int battleNo)
    {   
        Random rand = new Random();
        
        String ss = "";

        for(EnemyFleet temp : enemyFleetsList)
        {
            if(temp.getBattleNo() == battleNo)

                for(int i = 0; i < forcesList.size(); i++)  
                { 
                    int index = rand.nextInt(forcesList.size()); 
                    
                    if(temp.getBattleStrength() < forcesList.get(index).getBattleStrength())
                    {
                        ss = ss + "Battle won, battle gains added to the warchest.";
                        warchest = temp.getGains() + warchest;
                        return 0;
                    }

                    else if(forcesList.get(index).getState() == ForceState.DESTROYED)
                    {
                        ss = ss + "Battle lost as no suitable force available, battle losses.";
                        warchest = warchest - temp.getGains();
                        return 1;
                    }
                    else if(temp.getBattleStrength() > forcesList.get(index).getBattleStrength())
                    {
                        ss = ss + "Battle lost on battle strength";
                        warchest = warchest - temp.getGains();
                        return 2;
                    }
                
                    else if(forcesList.get(index).getActivationFee() < 100 && forcesList.isEmpty())
                    {
                        ss = ss + "Not available";
                        warchest = warchest - temp.getGains();
                        return 3;
                    }
                }                     
            }
            ss = ss + "No such battle";
            return 0;
    }

    //****************************Private Methods**************************// 
    private void setupForces()
    {
        Wing IW1 = new Wing("IW1","Twisters", 200, 10, 200);
        forcesList.add(IW1);
        Wing IW4 = new Wing("IW4", "Wingers", 200, 20, 400);
        forcesList.add(IW4);
        Wing IW10 = new Wing("IW10", "Flyers", 200, 5, 100);
        forcesList.add(IW10);

        Starship SS2 = new Starship("SS2","Enterprise", 300, 10, 200, 200);
        forcesList.add(SS2);
        Starship SS6 = new Starship("SS6","Voyager", 450, 15, 10, 200);
        forcesList.add(SS6);
        Starship SS7 = new Starship("SS7","Explorer", 120, 4, 5, 65);
        forcesList.add(SS7);

        Warbird WB3 = new Warbird("WB3","Droop", 300, 100, false);
        forcesList.add(WB3);
        Warbird WB5 = new Warbird("WB5","Hang", 400, 300, true);
        forcesList.add(WB5);
        Warbird WB9 = new Warbird("WB9","Hovers", 300, 400, false);
        forcesList.add(WB9);
    }
    
    private void setupBattles()
    {
        EnemyFleet bt1 = new EnemyFleet(1, BattleType.FIGHT, "Borg", 200, 300, 100);
        enemyFleetsList.add(bt1);
        EnemyFleet bt2 = new EnemyFleet(2, BattleType.SKIRMISH, "Kardassians", 700, 200, 120);
        enemyFleetsList.add(bt2);
        EnemyFleet bt3 = new EnemyFleet(3, BattleType.AMBUSH, "Ferengi", 100, 400, 150);
        enemyFleetsList.add(bt3);
        EnemyFleet bt4 = new EnemyFleet(4, BattleType.FIGHT, "Ewoks", 600, 600, 200);
        enemyFleetsList.add(bt4);
        EnemyFleet bt5 = new EnemyFleet(5, BattleType.AMBUSH, "Borg", 500, 400, 90);
        enemyFleetsList.add(bt5);
        EnemyFleet bt6 = new EnemyFleet(6, BattleType.SKIRMISH, "Groaners", 150, 100, 100);
        enemyFleetsList.add(bt6);
        EnemyFleet bt7 = new EnemyFleet(7, BattleType.FIGHT, "Borg", 150, 500, 300);
        enemyFleetsList.add(bt7);
        EnemyFleet bt8 = new EnemyFleet(8, BattleType.AMBUSH, "Wailers", 300, 300, 300);
        enemyFleetsList.add(bt8);
    }
    
    
    
   //**************************GETTERS*******************************/
    
    public String getBattle(int num)
    {
        String ss = "";
        
        for(EnemyFleet temp : enemyFleetsList)
        {
            if(temp.getBattleNo() == num)
            {
                ss = ss + temp.toString();
            }
            
            ss = ss + "Does not exist";
        }
        
        return ss;
    }
    

    public String getAllBattles()
    {
        String ss = "";
        for (EnemyFleet temp: enemyFleetsList)
        {
            ss = ss + temp.toString();
        }
        return ss;
    }

    
    public String getASFleet()
    {
        String ss = "";
        
        for(Force temp : forcesList)
        {
            if(temp.getState() == ForceState.ACTIVE)
            {
                ss = ss + temp.toString();
            }
        }
        return ss;
    }

    
    public String getForceDetails(String ref)
    {
        for (Force temp: forcesList)
        {
            if (temp.getReference().equals(ref))
            {
                return temp.toString();
            }
        }
        return "\nNo such force";
    }  
    
    
    public String getUFFleet()
    {   
        String ss = "";
        for (Force temp: forcesList)
        {
             if (temp.getState() == ForceState.DOCKED)
             {
                ss = ss + temp.toString();
             }
        }
        return ss;  
    }
    
   
    public String getAdmiralName()
    {
        return name;
    }
    
    public int getWarchest()
    {
        return warchest;
    }
    
    
    public String toString()
    {
        String ss = "";
        boolean hasForce = false;
        
        ss = ss + "Admiral Name: " + getAdmiralName() + "\nWarchest: " + getWarchest()
                + "\nForce: ";
        for(Force temp : forcesList)
        {
            if(temp.getState() == ForceState.ACTIVE)
            {
                ss = ss + temp.getName();
                hasForce = true;
            }
        }
        if(!hasForce)
        {
            ss = ss + "\nNo forces yet";
        } 
        return ss;
    }

    
    
    //*****************************Serialisation**********************/
    public void saveGame(String fname)
    {   
        String fileName = fname;
        try
        {
            ObjectOutputStream objSerial = new ObjectOutputStream(new FileOutputStream(fileName));
            for(Force temp : forcesList)
            {
                objSerial.writeObject(temp);
            }
            objSerial.close();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        
    }

    public SpaceWars restoreGame(String fname)
    {   
        SpaceWars obj = new SpaceWars(fname);
        String fileName = fname;
        
        try
        {
            ObjectInputStream inf  = new ObjectInputStream (new FileInputStream("spacewars.txt"));
            Force forces = null;
            forces = (Force)inf.readObject();
            
            while (forcesList != null)
            {
                forcesList.add(forces);
                forces = (Force)inf.readObject();
            }          
        }

        catch (EOFException e)
        {
            System.out.println("File read done");
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        
        System.out.println("Forces from file");
        
        return obj;
    } 
}



