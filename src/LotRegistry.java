import java.util.HashMap;
import java.util.HashSet;
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
     * LotRegistry constructor. Instantiates HashMap for LandLot objects
     */
    public LotRegistry() {
        this.lotMap = new HashMap<>();
    }//LotRegistry

    /**
     * Add a LandLot object to the registry.
     */
    public void addLot(LandLot newLot)
    {

        this.lotMap.put((newLot.getLotID()),newLot);
    }//addLot

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
     * Compares a search keyword to the lot ID of all land lots in collection,
     * and returns an iterator containing all matches.
     * @return iterator containing land lot objects with matching lot ID
     */
    public Iterator search(int muniNo, int lotNo, int sectionNo){
        Iterator it = getKeyIterator(); // make iterator of HashMap keys
        HashSet match = new HashSet<LandLot>(); //collect matching LandLot objects

        Integer[] searchValues = new Integer[]{muniNo, lotNo, sectionNo};

        while(it.hasNext())
        {
            String id = (String) it.next(); // The keys of lotMap are Strings
            // get next lot ID, i.e. HashMap key

            for(int i = 0; i < 3; i ++){ //for integers in searchValues
            if(id.contains(searchValues[i].toString()))// if ID contains searchValue[i]
            {
                match.add(lotMap.get(id));  // add LandLot to set of matches
            }//if
            }//for
        }//while
        return match.iterator();
    }

    /**
     * Returns the total number of lots held in registry
     * @return the number of lots held in registry.
     */
    public int getRegistrySize()
    {
        return lotMap.size();
    }

    /**
     * Returns the average of the area size of all land lots in registry.
     * @return double of average area size across all lots in registry.
     */
    public double getAverageArea()
    {
        double areaSum = lotMap.values().stream()   /*stream of all entries in HashMap*/
                .mapToDouble(LandLot::getArea)      /*map stream to area size of land lots */
                .sum();                             /*sum all land lot area sizes*/

        // average = sum of all entries / number of entries
        // divide sum of area by number of land lot objects in collection.
        return areaSum / lotMap.size();
    }

    /**
     * Returns an iterator object with all land lots with a matching lot number.
     * @param lotNumber the lot number to filter land lots by.
     * @return iterator of land lots that match parameter.
     * @deprecated unused in final applicaton
     */
    @Deprecated
    public Iterator filterByLotNumber(int lotNumber)
    {
        Iterator it = getValuesIterator();
        HashSet matchedLots = new HashSet<LandLot>();

        while(it.hasNext())
        {
            LandLot nextLot = (LandLot) it.next(); //iterator holds land lot objects
            if(nextLot.getLotNumber() == lotNumber)
            {
                matchedLots.add(lotMap.get(lotNumber));
            }

        }
        return matchedLots.iterator();
    }

    /**
     * Returns iterator of the keys of all objects in registry.
     * @return iterator of HashMap keys
     */
    public Iterator getKeyIterator()
    {
        return lotMap.keySet().iterator(); // make iterator of HashMap keys
    }

    /**
     * Returns iterator of the values of all objects in registry.
     * @return iterator of HashMap values.
     */
    public Iterator getValuesIterator()
    {
        return lotMap.values().iterator(); //make iterator of HashMap values
    }

    public LandLot getLotByID(String lotID)
    {
        return lotMap.get(lotID);
    }
}
