/**
 * A class that represents and holds information about a single lot of land property.
 * @author Olav Valle
 * @version 2019/11/12
 */
public class LandLot
{
    private String muniName; //kommunenavn
    private String ownerName; //the name of the person who owns the property
    private String lotName; // the name of the lot. Can be blank.
    private String lotID; // unique ID. String format is "muniNumber-lotNumber/sectionNumber"
    private int muniNumber; //kommunenummer
    private int lotNumber; //gardsnummer
    private int sectionNumber; //bruksnavn
    private double area; //the size of the property in square meters (m^2)

    /**
     * Constructor for Lot class, which represents a land property.
     * @param muniName name of the municipality the lot is in
     * @param muniNumber the municipality's ID number, a positive multi-digit integer
     * @param lotNumber the lot number, a positive multi-digit integer
     * @param sectionNumber the lot section number, a positive multi-digit integer
     * @param ownerName the full name of the owner of the lot
     * @param area the area size of the lot in square meters (m^2)
     * @param lotName the name of the lot, or an empty string if lot has no name
     */
    public LandLot(
            String muniName,
            int muniNumber,
            int lotNumber,
            int sectionNumber,
            String ownerName,
            double area,
            String lotName)
    {
        this.muniName = muniName;
        this.muniNumber = muniNumber;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.ownerName = ownerName;
        this.area = area;
        this.lotName = lotName;
        this.lotID = muniNumber + "-" + lotNumber + "/" + sectionNumber;


    }

    // accessor methods
    /**
     * Returns the lot's unique ID, which consists of the municipality number,
     * lot number and section number of the property, as a string.
     * The string is in the format "municipalNumber-lotNumber/sectionNumber",
     * i.e. a lot with municipality number 1234, lot number 56 and section number 78
     * would produce a string like this: "1234-56/78"
     * @return String of the lot's unique ID.
     */
    public String getLotID()
    {
        // the lotID field has been instantiated by LandLot constructor
        return this.lotID;
    }

    /**
     * Returns the name of the municipality the lot is located in.
     * @return The name of the municipality the lot is located in.
     */
    public String getMuniName()
    {
        return this.muniName;
    }

    /**
     * Returns the municipality number of municipality the lot is located in.
     * @return the municipality number of municipality the lot is located in.
     */
    public int getMuniNumber()
    {
        return this.muniNumber;
    }

    /**
     * Returns the name of the owner of the lot.
     * @return the name of the owner of the lot.
     */
    public String getOwnerName()
    {
        return ownerName;
    }

    /**
     * Returns the name of the lot, if it has one, or an empty string if it has no name.
     * @return the name of the lot, if any
     */
    public String getLotName()
    {
        return lotName;
    }

    /**
     * Returns the area of the lot in square meters (m^2), as a double.
     * @return the area of the lot in square meters (m^2)
     */
    public double getArea()
    {
        return area;
    }

    /**
     * Returns the lot number.
     * @return the lot number.
     */
    public int getLotNumber()
    {
        return lotNumber;
    }

    /**
     * Returns the section number of the lot.
     * @return the section number of the lot.
     */
    public int getSectionNumber()
    {
        return sectionNumber;
    }

    // Mutators

    // There are only mutators for fields that are likely to change.
    // In other words, the name of the owner (in case the lot is sold),
    // the area (in case the lot's borders are expanded), and the name of the lot

    /**
     * Set the lot name.
     * @param lotName the new name of the lot.
     */
    public void setLotName(String lotName)
    {
        this.lotName = lotName;
    }

    /**
     * Set the name of the owner of the lot.
     * @param ownerName the name of the lot owner.
     */
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    /**
     * Sets the size of the lot in square meters (m^2)
     * @param area size of lot in square meters
     */
    public void setArea(double area)
    {
        this.area = area;
    }
}
