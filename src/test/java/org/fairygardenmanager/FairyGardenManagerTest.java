package org.fairygardenmanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FairyGardenManagerTest {
    private FairyGardenManager manager;

    @BeforeEach
    public void setUp() {
        manager = new FairyGardenManager();
    }

    @Test
    public void testPlantFlower_EnoughMagicDust() {
        assertEquals("Rose planted successfully!", manager.plantFlower("Rose"));
    }

    @Test
    public void testPlantFlower_NotEnoughMagicDust() {
        manager.plantFlower("Rose");
        manager.plantFlower("Lily");
        manager.plantFlower("Sunflower");
        manager.plantFlower("Tulip");
        manager.plantFlower("Daisy");
        assertEquals("Not enough magic dust to plant Tulip!", manager.plantFlower("Tulip"));
    }

    @Test
    public void testWaterGarden_NotEnoughWater() {
        manager.plantFlower("Rose");
        manager.waterGarden();
        manager.waterGarden();
        manager.waterGarden();
        manager.waterGarden();
        manager.waterGarden();
        assertEquals("Not enough water droplets!", manager.waterGarden());
    }

    @Test
    public void testWaterGarden_NoFlowers() {
        manager.gatherMagicDust();
        assertEquals("No flowers to water!", manager.waterGarden());
    }

    @Test
    public void testWaterGarden_Success() {
        manager.plantFlower("Rose");
        assertEquals("Garden watered successfully, flowers are happy!", manager.waterGarden());
    }

    @Test
    public void testBefriendMagicFriend_AlreadyFriend() {
        manager.plantFlower("Rose");
        manager.plantFlower("Tulip");
        manager.plantFlower("Daisy");
        manager.plantFlower("Sunflower");
        manager.plantFlower("Lily");
        manager.befriendMagicFriend();
        assertEquals("You already have a magic friend!", manager.befriendMagicFriend());
    }

    @Test
    public void testBefriendMagicFriend_NotEnoughFlowers() {
        manager.plantFlower("Rose");
        assertEquals("You need to plant at least 5 flowers to attract a magic friend!", manager.befriendMagicFriend());
    }

    @Test
    public void testBefriendMagicFriend_Success() {
        manager.plantFlower("Rose");
        manager.plantFlower("Tulip");
        manager.plantFlower("Daisy");
        manager.plantFlower("Sunflower");
        manager.plantFlower("Lily");
        assertEquals("A magic friend has become your friend!", manager.befriendMagicFriend());
        assertTrue(manager.hasMagicFriend());
    }

    @Test
    public void testGatherMagicDust() {
        assertEquals("Magic dust gathered!", manager.gatherMagicDust());
    }

    @Test
    public void testGetMagicDust() {
        assertEquals(50, manager.getMagicDust());
    }

    @Test
    public void testGetWaterDroplets() {
        assertEquals(100, manager.getWaterDroplets());
    }

    @Test
    public void testGetFlowersPlanted() {
        assertEquals(0, manager.getFlowersPlanted());
    }

    @Test
    public void testHasMagicFriend() {
        assertFalse(manager.hasMagicFriend());
    }
}
