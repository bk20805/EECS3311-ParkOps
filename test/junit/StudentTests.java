// Add focused @org.junit.jupiter.api.Test methods here.
// Create fresh objects for each test and assert results AND unchanged state on rejection.
// The supplied wrapper is not a substitute for your own test design.
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StudentTests { 
    @Test
    void durationEndPointsCheck(){
        assertEquals(1,new Booking("B1","A17",1,0,false).getDurationHours());
        assertEquals(24,new Booking("B1","A17",24,0,false).getDurationHours());
        assertThrows(IllegalArgumentException.class,()-> new Booking("B1","A17",25,0,false));
        assertThrows(IllegalArgumentException.class,()-> new Booking("B1","A17",0,0,false));
    }

    @Test
    void nullAndInvalidIdentifierRejected(){
        assertThrows(IllegalArgumentException.class,()->DomainRules.requireIdentifier(null));
        assertThrows(IllegalArgumentException.class,()->DomainRules.requireIdentifier("b1"));
        assertThrows(IllegalArgumentException.class,()->DomainRules.requireIdentifier("A12345678901234567890"));
    }

    @Test
    void eligibleB12ProposalPendingAndBookingUnchanged() {
        StudentApplication app=new StudentApplication();
        var before=app.bookingSnapshot();
        ProposalView pv=app.propose("B12");
        assertEquals("PENDING",pv.status());
        assertEquals("B12",pv.targetId());
        assertEquals(0,pv.bookingVersion());
        assertEquals(1,pv.policyVersion());
        assertEquals(before,app.bookingSnapshot());
        assertEquals("A17",app.bookingSnapshot().get("spaceId"));
        assertEquals(0,app.bookingSnapshot().get("version"));
    }

    @Test
    void occupiedD09Rejected(){
        StudentApplication app=new StudentApplication();
        var before=app.bookingSnapshot();
        assertThrows(IllegalArgumentException.class,()->app.propose("D09"));
        assertEquals(before,app.bookingSnapshot());
        assertEquals("A17",app.bookingSnapshot().get("spaceId"));
        assertEquals(0,app.bookingSnapshot().get("version"));
    }

    @Test
    void unknownTargetRejected(){
        StudentApplication app=new StudentApplication();
        var before=app.bookingSnapshot();
        assertThrows(IllegalArgumentException.class,()->app.propose("Q90"));
        assertEquals(before,app.bookingSnapshot());
        assertEquals("A17",app.bookingSnapshot().get("spaceId"));
        assertEquals(0,app.bookingSnapshot().get("version"));
    }

    @Test
    void bookingSnapshotCannotBeModified(){
        StudentApplication app=new StudentApplication();
        var snapshot=app.bookingSnapshot();
        assertThrows(UnsupportedOperationException.class,()->snapshot.clear());
        assertEquals("A17",app.bookingSnapshot().get("spaceId"));
        assertEquals(0,app.bookingSnapshot().get("version"));
    }






}
