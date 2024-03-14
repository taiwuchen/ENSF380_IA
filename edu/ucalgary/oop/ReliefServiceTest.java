/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-02-10";
    private String invalidDate = "2024/02/10";
    private String expectedInfoProvided = "Looking for family member";
    private String expectedLogDetails = "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary"; 

    @Before
    public void setUp() {
        // Assuming Inquirer, DisasterVictim, and Location have constructors as implied
        inquirer = new Inquirer("John", "Alex", "1234567890", "Looking for family member");
        missingPerson = new DisasterVictim("Jane Alex", "2024-01-25");
        lastKnownLocation = new Location("University of Calgary", "2500 University Dr NW");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }
    
    @Test
    public void testSetInquirer() {
        Inquirer newInquirer = new Inquirer("Jane", "Doe", "0987654321", "Looking for friend");
        reliefService.setInquirer(newInquirer);
        assertEquals("setInquirer should correctly update the inquirer", newInquirer, reliefService.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson, reliefService.getMissingPerson());
    }
    @Test
    public void testSetMissingPerson() {
        DisasterVictim newMissingPerson = new DisasterVictim("John Doe", "2024-01-26");
        reliefService.setMissingPerson(newMissingPerson);
        assertEquals("setMissingPerson should correctly update the missing person", newMissingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided, reliefService.getInfoProvided());
    }
    
    @Test
    public void testSetInfoProvided() {
        String newInfoProvided = "Looking for cousin";
        reliefService.setInfoProvided(newInfoProvided);
        assertEquals("setInfoProvided should correctly update the info provided", newInfoProvided, reliefService.getInfoProvided());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }
    
    @Test
    public void testSetLastKnownLocation() {
        Location newLastKnownLocation = new Location("University of Alberta", "116 St & 85 Ave");
        reliefService.setLastKnownLocation(newLastKnownLocation);
        assertEquals("setLastKnownLocation should correctly update the last known location", newLastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testSetDateOfInquiryWithValidDate() {
        reliefService.setDateOfInquiry(validDate);
        assertEquals("Setting a valid date should update the date of inquiry", validDate, reliefService.getDateOfInquiry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate); // This should throw IllegalArgumentException due to invalid format
    }
    
    @Test
    public void testGetInteractionLogforInquirer() {
        LinkedList<String> expectedInteractionLog = new LinkedList<>();
        expectedInteractionLog.add("Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary");
        assertTrue("getInteractionLogforInquirer should return the interaction log for the inquirer", reliefService.getInteractionLogforInquirer().containsAll(expectedInteractionLog));
    }

    @Test
    public void testAddInteractionforInquirer() {
        String newInteraction = "Inquirer: Jane, Missing Person: John Doe, Date of Inquiry: 2024-02-11, Info Provided: Looking for friend, Last Known Location: University of Alberta";
        reliefService.addInteractionforInquirer(newInteraction);
        assertTrue("addInteractionforInquirer should add an interaction for the inquirer", reliefService.getInteractionLogforInquirer().contains(newInteraction));
    }

    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }
    
    
}
