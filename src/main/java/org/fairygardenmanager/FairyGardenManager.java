package org.fairygardenmanager;

public class FairyGardenManager {
    private int magicDust;
    private int waterDroplets;
    private int flowersPlanted;
    private boolean hasMagicFriend;

    public FairyGardenManager() {
        this.magicDust = 50;
        this.waterDroplets = 100;
        this.flowersPlanted = 0;
        this.hasMagicFriend = false;
    }

    public String plantFlower(String flowerType) {
        if (magicDust < 10) {
            return "Not enough magic dust to plant " + flowerType + "!";
        } else {
            magicDust -= 10;
            flowersPlanted++;
            return flowerType + " planted successfully!";
        }
    }

    public String waterGarden() {
        if (waterDroplets < 20) {
            return "Not enough water droplets!";
        } else if (flowersPlanted == 0) {
            return "No flowers to water!";
        } else {
            waterDroplets -= 20;
            return "Garden watered successfully, flowers are happy!";
        }
    }

    public String befriendMagicFriend() {
        if (hasMagicFriend) {
            return "You already have a magic friend!";
        } else if (flowersPlanted < 5) {
            return "You need to plant at least 5 flowers to attract a magic friend!";
        } else {
            hasMagicFriend = true;
            return "A magic friend has become your friend!";
        }
    }

    public String gatherMagicDust() {
        magicDust += 20;
        return "Magic dust gathered!";
    }

    public int getMagicDust() {
        return magicDust;
    }

    public int getWaterDroplets() {
        return waterDroplets;
    }

    public int getFlowersPlanted() {
        return flowersPlanted;
    }

    public boolean hasMagicFriend() {
        return hasMagicFriend;
    }
}