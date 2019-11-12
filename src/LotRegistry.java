import java.util.HashMap;
import java.util.Iterator;

/**
 * A registry holding a collection of LandLot objects.
 * Provides methods for adding and removing land lots from registry,
 * and searching for lots using lot IDs, municipal ID, lot number and section number.
 *
 * @author Olav Valle
 * @version 2019/11/12
 */
public class LotRegistry {

    private HashMap<String, LandLot> lotMap;
    // HashMap of land lot objects, using lotIDs as keys
    /*
    / As each land lot should have a unique lot ID, using this ID as the key for the hash map
    / is an easy way to quickly distinguish and locate specific lots in the collection by
    / utilising Map class methods.
    */



    /**
     * LotRegistry constructor.
     */
    public LotRegistry() {
        this.lotMap = new HashMap<>();
        // instantiates HashMap for LandLot objects
    }

    /**
     * Creates a new land lot object and adds it to registry.
     *
     * Will be refactored to Interface class.
     *
     * @param muniName name of the municipality the lot is in
     * @param muniNumber the municipality's ID number, a positive multi-digit integer
     * @param lotNumber the lot number, a positive multi-digit integer
     * @param sectionNumber the lot section number, a positive multi-digit integer
     * @param ownerName the full name of the owner of the lot
     * @param area the area size of the lot in square meters (m^2)
     * @param lotName the name of the lot, or an empty string if lot has no name
     */
    public void addNewLot(String muniName, int muniNumber, int lotNumber, int sectionNumber, String ownerName, double area, String lotName)
    {
        addLot(new LandLot(muniName, muniNumber, lotNumber, sectionNumber, ownerName, area, lotName));
    }

    /**
     * Add a LandLot object to the registry.
     */
    public void addLot(LandLot newLot)
    {
        this.lotMap.put((newLot.getLotID()),newLot);
    }

    /**
     * Remove a LandLot object from registry by specifying the lot ID of the lot.
     */
    public void removeLot(String lotID)
    {
        if(lotMap.containsKey(lotID)) // check that registry has match for key
        {
            lotMap.remove(lotID); // remove LandLot from registry
        }
    }

    /**
     * search
     */
    public void search(){
        Iterator it = lotMap.values().iterator(); // make iterator
        //it.forEachRemaining();
    }

    /**
     * Returns the total number of lots held in registry
     * @return the number of lots held in registry.
     */
    public int getRegistrySize()
    {
        return lotMap.size();
    }
}
