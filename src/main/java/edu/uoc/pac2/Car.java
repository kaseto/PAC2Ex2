package edu.uoc.pac2;

import java.time.LocalDate;

/**
 * Car class
 *
 * Contains information of each car
 *
 * @author Miguel Perales Rubio
 * @version 1.0
 *
 *
 */

public class Car {
    /**
     * Car' VAT_SPAIN, spanish taxes
     */
    private static final double VAT_SPAIN=21;
    /**
     * Car' VAT_FRANCE, French taxes
     */
    private static final double VAT_FRANCE=21.5;
    /**
     * Car' id, identification of each car
     */
    private int id=nextId ;
    /**
     * Car' nextId, identification of the next car
     */
    private static int nextId=0 ;
    /**
     * Car' make, car brand
     */
    private String make;
    /**
     * Car' model, car model
     */
    private String model;
    /**
     * Car' licenseYear, car registration year
     */
    private int licenseYear;
    /**
     * Car' fuel, car fuel type
     */
    private char fuel='P';
    /**
     * Car' licensePlate, car registration plate
     */
    private String licensePlate;
    /**
     * Car' price, car price
     */
    private double price;

    /**
     * Default constructor
     */

    public Car() {
        this.licensePlate="0000CDV";
        setPrice(10000);
        this.make="Lorem";
        this.model="IPSUM";
        this.licenseYear=2000;
        this.id=getId();


    }

    /**
     * Constructor with parameters
     * @param make car brand
     * @param model car model
     * @param licenseYear car registration year
     * @param fuel car fuel type
     * @param licensePlate car registration plate
     * @param price car price
     */

    public Car(String make, String model, int licenseYear, char fuel, String licensePlate, double price) {
        setLicensePlate(licensePlate);
        setPrice(price);
        this.licensePlate=getLicensePlate();
        this.price=getPrice();
        this.fuel=fuel;
        this.make=make;
        this.model=model;
        this.licenseYear=licenseYear;
        id=getId();
    }
    /**
     * Method that returns the ID
     * @return id
     */
    public int getId() {

        nextId++;
        return id;
    }

    /**
     * Method that defines the ID
     */

    private void setId() {

    }

    /**
     * Method that returns the next ID
     * @return nextId
     */

    public static int getNextId() {
       nextId++;
       return nextId;
    }

    /**
     * Method that defines the ID
     * @param nextId
     */

    private void setNexId(int nextId) {
        nextId++;
    }

    /**
     * Method that returns the car brand
     * @return make
     */

    public String getMake() {
        return make;
    }

    /**
     * Method that defines the car brand
     * @param make
     * <ul>
     *     <li>check if the string is less than 15</li>
     *     <li>pass the string to the correct format</li>
     *</ul>
     * @throws Exception in case of error a warning is issued
     */

    public void setMake(String make)throws Exception {
       String lowerCase="";
        if(make.length()<15){
            for (int i=0;i<make.length()+1;i++) {
               lowerCase = make.substring(0, i).toLowerCase() + make.substring(i);
            }
            this.make=make.substring(0,1).toUpperCase()+lowerCase.substring(1);

        }else
        throw new Exception("[ERROR] Car's make cannot be longer than 15 characters");
    }

    /**
     * Method that returns the car model
     * @return model
     */

    public String getModel() {
        return model;
    }

    /**
     * Method that defines the car model
     * @param model
     * <ul>
     *     <li>Convert the String to uppercase</li>
     * </ul>
     * @throws Exception If the string is greater than 20 characters, a warning is displayed
     */
    public void setModel(String model)throws  Exception {
        if(model.length()<20) this.model = model.toUpperCase();
        else throw new Exception("[ERROR] Car's model cannot be longer than 20 characters");
    }

    /**
     * Method that returns the car registration year
     * @return licenseYear
     */

    public int getLicenseYear() {
        return licenseYear;
    }

    /**
     * Method that defines the car registration year
     * @param licenseYear
     * <ul>
     *     <li>Check if the year of registration is after 2000 and if it is under warranty</li>
     * </ul>
     * @throws Exception If the year of registration is prior to 2000, a warning appears
     */

    public void setLicenseYear(int licenseYear) throws Exception{
       if(licenseYear>2000&&licenseYear<LocalDate.now().getYear()) this.licenseYear = licenseYear;
       else throw new Exception("[ERROR] Car's license year must be in range [2000, current year]");
    }

    /**
     * Method that returns the car fuel
     * @return fuel
     */

    public char getFuel() {
        return fuel;
    }

    /**
     * Method that defines the car fuel type
     * @param fuel
     * <ul>
     *     <li>check if the variable fuel is correct</li>
     * </ul>
     * @throws Exception in case of error the exception is thrown
     */

    public void setFuel(char fuel) throws  Exception{
        if (fuel == 'P' || fuel == 'H' || fuel == 'D' || fuel == 'E') {
            this.fuel = fuel;
        } else {
            throw new Exception("[ERROR] Car's fuel is incorrect");
        }
    }

    /**
     * Method that returns the car warranty
     * @return year-license year if it is less than or equal to 5
     */

    public boolean getWarranty(){
        int year=LocalDate.now().getYear();
        System.out.println(getLicenseYear());
        return year - licenseYear <= 5;
    }

    /**
     * Method that returns the car registration plate
     * @return licensePlate
     */

    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Method that defines the car registration plate
     * @param licensePlate
     * <ul>
     *     <li>Check if the registration format is correct, in Spain and in France</li>
     *     <li>If the pattern is not correct, a warning is displayed</li>
     * </ul>
     */
    public void setLicensePlate(String licensePlate) {
        if(licensePlate.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")){
            this.licensePlate = licensePlate;
        }
        else if (licensePlate.toUpperCase().matches("^[A-Z]{2}[-][0-9]{3}[-][A-Z]{2}$")){
            this.licensePlate = licensePlate;

        }else System.out.println("[ERROR] Car's license plate pattern is incorrect");
    }

    /**
     * Method that returns the car price
     * @return price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Method that defines the car price
     * @param price
     * <ul>
     *     <li>Check if the license plate is French or Spanish</li>
     *     <li>check if the price is greater than 0</li>
     *     <li>calculate the price with the taxes of the corresponding country</li>
     *     <li>If the price is less than 0, a warning is displayed.</li>
     * </ul>
     */

    public void setPrice(double price) {
       this.price = price;
        char symbol=getLicensePlate().charAt(2);
        if(price>0){
            if (symbol=='-')this.price+=price*VAT_FRANCE/100;
            else this.price+=price*VAT_SPAIN/100;
        }else System.out.println("[ERROR] Car's price must be greater than 0");
    }
}
