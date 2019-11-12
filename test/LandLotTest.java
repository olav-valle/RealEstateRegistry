import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* Test Values
        Kommune navn	Kommune nr	Gårdsnr	Bruksnr	Bruksnavn	Areal (m2)	Eier
        Gloppen	        1445	    77      631	 	            1017,6	    Jens Olsen
        Gloppen	        1445	    77	    131	    Syningom	661,3	    Nicolay Madsen
        Gloppen	        1445	    75	    19	    Fugletun	650,6	    Evilyn Jensen
        Gloppen	        1445	    74	    188	 	            1457,2	    Karl Ove Bråten
        Gloppen	        1445	    69	    47	    Høiberg	    1339,4	    Elsa Indregård

 */
class LandLotTest {

    private LandLot lot1;

    @BeforeEach
    void setUp() {
        lot1 = new LandLot("Gloppen",1445,77,631,"Jens Olsen",1017.6,"");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLotID() {
        //System.out.println(lot1.getLotID());
        assertEquals("1445-77/631", lot1.getLotID());
    }

    @Test
    void getMuniName() {
        assertEquals("Gloppen", lot1.getMuniName());

    }

    @Test
    void getMuniNumber() {
        assertEquals(1445, lot1.getMuniNumber());
    }

    @Test
    void getOwnerName() {
        assertEquals("Jens Olsen", lot1.getOwnerName());
    }

    @Test
    void getLotName() {
        assertEquals("", lot1.getLotName());
    }

    @Test
    void getArea() {
        assertEquals(1017.6, lot1.getArea());
    }

    @Test
    void getLotNumber() {
        assertEquals(77, lot1.getLotNumber());
    }

    @Test
    void getSectionNumber() {
        assertEquals(631, lot1.getSectionNumber());
    }

    @Test
    void setLotName() {
        String newName = "NewTestLotName";
        assertEquals("", lot1.getLotName()); // assert that lot name is empty
        lot1.setLotName(newName); // set new lot name
        assertEquals(newName, lot1.getLotName()); // assert that lot name has been changed
    }

    @Test
    void setOwnerName() {
        String newOwner = "NewTestOwnerName";
        assertEquals("Jens Olsen", lot1.getOwnerName()); // assert original owner name
        lot1.setOwnerName(newOwner); // set new owner name
        assertEquals(newOwner, lot1.getOwnerName()); // assert that owner name has been changed
    }

    @Test
    void setArea() {
        double newArea = 133.7;
        assertEquals(1017.6, lot1.getArea()); // assert original area size
        lot1.setArea(newArea); // set new area size
        assertEquals(newArea, lot1.getArea()); // assert area size was changed
    }
}
