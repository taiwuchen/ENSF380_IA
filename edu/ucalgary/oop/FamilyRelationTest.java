/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {

    private LinkedList<DisasterVictim> relatedPersons = new LinkedList<>();
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
	
    @Test
    public void testSetAndGetRelatedPersons() {
            LinkedList<DisasterVictim> newRelatedPersons = new LinkedList<>();
            newRelatedPersons.add(new DisasterVictim("New Person", "2024-03-21"));
            testFamilyRelationObject.setRelatedPersons(newRelatedPersons);
            assertEquals("setRelatedPersons should update relatedPersons", newRelatedPersons, testFamilyRelationObject.getRelatedPersons());
        }

    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }
}
