package Model;

/**
 * Customer Object populated through Application add or from database
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String postal_code;
    private String phone;
    private String create_date;
    private String createad_by;
    private String last_update;
    private String last_updated_by;
    private int division_id;

    private String division;
    private String country;

    /**
     * Constructor for Customer, utilized during addition or query from database
     * @param id ID to be set
     * @param name name to be set
     * @param address address to be set
     * @param postal_code postal code to be set
     * @param phone phone to be set
     * @param create_date create date to be set
     * @param createad_by created by to be set
     * @param last_update last update to be set
     * @param last_updated_by last updated by to be set
     * @param division_id division id to be set
     * @param division division String taken from division id to be set
     * @param country country String taken from division id to be set
     */
    public Customer(int id, String name, String address, String postal_code, String phone, String create_date,
                    String createad_by, String last_update, String last_updated_by, int division_id, String division,
                    String country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.create_date = create_date;
        this.createad_by = createad_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
        this.division_id = division_id;
        this.division = division;
        this.country = country;
    }

    /**
     *
     * @return returns Customer ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return returns Customer name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return returns Customer address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return returns Customer postal code
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     *
     * @return returns Customer phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return returns Customer diuision String
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @return returns Customer create date
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     *
     * @return returns Customer created by user
     */
    public String getCreatead_by() {
        return createad_by;
    }

    /**
     *
     * @return returns Customer last update date
     */
    public String getLast_update() {
        return last_update;
    }

    /**
     *
     * @return returns Customer last update user
     */
    public String getLast_updated_by() {
        return last_updated_by;
    }

    /**
     *
     * @return returns Customer division id
     */
    public int getDivision_id() {
        return division_id;
    }

    /**
     *
     * @return returns Customer country String
     */
    public String getCountry() {
        return country;
    }


}
