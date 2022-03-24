package edu.uoc.pac2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {

    Car car;

    @BeforeAll
    void init() {
        try {
            car = new Car("Seat", "IBIZA", 2010, 'D', "9898HJC", 8500.50);
        } catch (Exception e) {
            fail("Default constructor failed");
        }
    }

    @Test
    @Order(1)
    void testCarDefault() {
        try {
            Car carDefault = new Car();
            assertEquals(1, carDefault.getId());
            assertEquals("Lorem", carDefault.getMake());
            assertEquals("IPSUM", carDefault.getModel());
            assertEquals(2000, carDefault.getLicenseYear());
            assertEquals('P', carDefault.getFuel());
            assertEquals("0000CDV", carDefault.getLicensePlate());
            assertFalse(carDefault.getWarranty());
            assertEquals(12100, carDefault.getPrice());
        } catch (Exception e) {
            fail("Default constructor failed");
        }
    }

    @Test
    @Order(2)
    void testCar() {
        assertEquals(0, car.getId());
        assertEquals("Seat", car.getMake());
        assertEquals("IBIZA", car.getModel());
        assertEquals(2010, car.getLicenseYear());
        assertEquals('D', car.getFuel());
        assertEquals("9898HJC", car.getLicensePlate());
        assertFalse(car.getWarranty());
        assertEquals(10285.605, car.getPrice());
    }


    @Test
    @Order(3)
    void testGetId() {
        assertEquals(0, car.getId());
    }

    @Test
    @Order(4)
    void testGetMake() {
        assertEquals("Seat", car.getMake());
    }

    @Test
    @Order(5)
    void testSetMake() {
        try{
            car.setMake("auDI");
            assertEquals("Audi", car.getMake());
        }catch(Exception e) {
            fail("testSetMake failed");
        }
    }

    @Test
    @Order(6)
    void testSetMakeException() {
        Exception ex = assertThrows(Exception.class, () ->	car.setMake("Lorem ipsum dolo"));
        assertEquals("[ERROR] Car's make cannot be longer than 15 characters", ex.getMessage());
    }

    @Test
    @Order(7)
    void testGetModel() {
        assertEquals("IBIZA", car.getModel());
    }


    @Test
    @Order(8)
    void testSetModel() {
        try{
            car.setModel("ToleDo");
            assertEquals("TOLEDO", car.getModel());

            car.setModel("Ibiza Kit Car");
            assertEquals("IBIZA KIT CAR", car.getModel());
        }catch(Exception e) {
            fail("testSetModel failed");
        }
    }

    @Test
    @Order(9)
    void testSetModelException() {
        Exception ex = assertThrows(Exception.class, () ->	car.setModel("Lorem ipsum dolo lore"));
        assertEquals("[ERROR] Car's model cannot be longer than 20 characters", ex.getMessage());
    }


    @Test
    @Order(10)
    void testGetLicenseYear() {
        assertEquals(2010, car.getLicenseYear());
    }

    @Test
    @Order(11)
    void testSetLicenseYear() {
        try{
            car.setLicenseYear(2019);
            assertEquals(2019, car.getLicenseYear());
        }catch(Exception e) {
            fail("testSetLicenseYear failed");
        }
    }

    @Test
    @Order(12)
    void testSetLicenseYearException() {

        Exception ex = assertThrows(Exception.class, () -> car.setLicenseYear(1999));
        assertEquals("[ERROR] Car's license year must be in range [2000, current year]", ex.getMessage());

        ex = assertThrows(Exception.class, () -> car.setLicenseYear(2023));
        assertEquals("[ERROR] Car's license year must be in range [2000, current year]", ex.getMessage());

        try{
            assertEquals(2019, car.getLicenseYear());
        }catch(Exception e) {
            fail("testSetLicenseYearException failed");
        }
    }


    @Test
    @Order(13)
    void testGetFuel() {
        assertEquals('D', car.getFuel());
    }

    @Test
    @Order(14)
    void testSetFuel() {
        try{
            car.setFuel('P');
            assertEquals('P', car.getFuel());

            car.setFuel('E');
            assertEquals('E', car.getFuel());

            car.setFuel('D');
            assertEquals('D', car.getFuel());

            car.setFuel('H');
            assertEquals('H', car.getFuel());

        }catch(Exception e) {
            fail("testSetFuel failed");
        }
    }

    @Test
    @Order(15)
    void testSetFuelException() {

        Exception ex = assertThrows(Exception.class, () -> car.setFuel('p'));
        assertEquals("[ERROR] Car's fuel is incorrect", ex.getMessage());

        ex = assertThrows(Exception.class, () -> car.setFuel('N'));
        assertEquals("[ERROR] Car's fuel is incorrect", ex.getMessage());

        ex = assertThrows(Exception.class, () -> car.setFuel('r'));
        assertEquals("[ERROR] Car's fuel is incorrect", ex.getMessage());

        assertEquals('H', car.getFuel());

    }

    @Test
    @Order(16)
    void testWarranty() {
        assertTrue(car.getWarranty());

        try {
            car.setLicenseYear(2015);
            assertFalse(car.getWarranty());

            car.setLicenseYear(2020);
            assertTrue(car.getWarranty());

            car.setLicenseYear(2015);
            assertFalse(car.getWarranty());
        } catch (Exception e) {
            fail("testWarranty failed");
            e.printStackTrace();
        }
    }
}