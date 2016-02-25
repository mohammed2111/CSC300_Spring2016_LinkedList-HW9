package com.example.awesomefat.linkedlist;

/**
 * Created by awesomefat on 2/23/16.
 */
public class TOHCore
{
    static TowerFragment tower1 = null;
    static TowerFragment tower2 = null;
    static TowerFragment tower3 = null;
    static int diskSize;

    static void toggleTowerButtons(TowerFragment sourceTower)
    {
        TowerFragment[] towerCollection = {tower1, tower2, tower3};
        sourceTower.setButtonText(3);
        for(TowerFragment tower : towerCollection)
        {
            if(tower != sourceTower)
            {
                tower.setButtonText(2);
            }
        }
    }

    static void resetTowerButtons()
    {
        TowerFragment[] towerCollection = {tower1, tower2, tower3};
        for(TowerFragment tower: towerCollection)
        {
            tower.setButtonText(1);
        }
    }
}