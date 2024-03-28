package org.fairygardenmanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FairyGardenManagerTest {
    private FairyGardenManager manager;

    @BeforeEach
    @DisplayName("Setting up Fairy Garden Manager")
    public void setUp() {
        manager = new FairyGardenManager();
    }

    @Test
    @DisplayName("Test to get if the plant was planted successfully")
    public void testPlantFlower_EnoughMagicDust() {
        assertEquals("Rose planted successfully!", manager.plantFlower("Rose"));
    }

    @Test
    @DisplayName("Test to get if the magic dust is enough")
    public void testPlantFlower_NotEnoughMagicDust() {
        manager.plantFlower("Rose");
        manager.plantFlower("Lily");
        manager.plantFlower("Sunflower");
        manager.plantFlower("Tulip");
        manager.plantFlower("Daisy");
        assertEquals("Not enough magic dust to plant Tulip!", manager.plantFlower("Tulip"));
    }

    @Test
    @DisplayName("Test to get if the water is enough")
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
    @DisplayName("Test to get if there are flowers to water")
    public void testWaterGarden_NoFlowers() {
        manager.gatherMagicDust();
        assertEquals("No flowers to water!", manager.waterGarden());
    }

    @Test
    @DisplayName("Test to get if the garden is watered successfully")
    public void testWaterGarden_Success() {
        manager.plantFlower("Rose");
        assertEquals("Garden watered successfully, flowers are happy!", manager.waterGarden());
    }

    @Test
    @DisplayName("Test to get if you have a magic friend")
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
    @DisplayName("Test to get if the planted flowers are enough")
    public void testBefriendMagicFriend_NotEnoughFlowers() {
        manager.plantFlower("Rose");
        assertEquals("You need to plant at least 5 flowers to attract a magic friend!", manager.befriendMagicFriend());
    }

    @Test
    @DisplayName("Test to get if the magic friend has become your friend")
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
    @DisplayName("Test to get if the magic dust is gathered ")
    public void testGatherMagicDust() {
        assertEquals("Magic dust gathered!", manager.gatherMagicDust());
    }

    @Test
    @DisplayName("Test to get if the magic dust")
    public void testGetMagicDust() {
        assertEquals(50, manager.getMagicDust());
    }

    @Test
    @DisplayName("Test to get if the water droplets")
    public void testGetWaterDroplets() {
        assertEquals(100, manager.getWaterDroplets());
    }

    @Test
    @DisplayName("Test to get if the planted flowers")
    public void testGetFlowersPlanted() {
        assertEquals(0, manager.getFlowersPlanted());
    }

    @Test
    @DisplayName("Test to get if the magic friend ")
    public void testHasMagicFriend() {
        assertFalse(manager.hasMagicFriend());
    }
}
