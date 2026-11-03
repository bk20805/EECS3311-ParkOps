import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public final class StudentApplication {
    private final Booking booking;
    private final List<Space> spaces=new ArrayList<>();
    private final List<Proposal> proposals=new ArrayList<>();
    private int nextPropNum=1;
    private final int policyVersion=1;
    
    public StudentApplication(){
        Map<String,Object> bookingData=Fixture.booking();
        booking=new Booking((String) bookingData.get("id"),(String) bookingData.get("spaceId"),(Integer) bookingData.get("durationHours"),(Integer) bookingData.get("version"),(Boolean) bookingData.get("requiresAccessible"));

        for (Map<String, Object> spaceData:Fixture.spaces()){
            Space space = new Space((String) spaceData.get("id"),(Boolean) spaceData.get("open"),(Boolean) spaceData.get("occupied"),(Boolean) spaceData.get("accessible"));
            spaces.add(space);
        }
        
    }
    // Raw fixture storage only. Replace or wrap it with your protected domain objects.
    // AMENDED 2026-09-18: You may create/initialise bookings here or in your own
    // domain classes. An approved client route uses the mapped equivalent entity.
    // See PROJECT_AMENDMENT_2026-09-18.md; this is deliberately unfinished starter code.
    public Map<String,Object> bookingSnapshot() { return Map.copyOf(booking.snapshot()); }
    public ProposalView propose(String targetId) {
        // TODO D1: validate target and baseline eligibility, generate an ID, capture
        // versions, create PENDING proposal. "Here" means this propose method:
        // preserve the complete current booking and occupancy state, including its
        // location and version. For B12, B1 stays at A17/version 0; do not free A17,
        // occupy B12, or replace B1 with a new booking at B12. Rejections also leave
        // state unchanged. Initialising the fixture is allowed; applying a move is
        // a later D2 operation after human approval and current-state revalidation.
        // This starter API reports a rejected target using IllegalArgumentException.
        DomainRules.requireIdentifier(targetId);
        Space target=null;
        for (Space space:spaces){
            if (space.getId().equals(targetId)){
                target=space;
                break;
            }

        }
        if(target==null){
            throw new IllegalArgumentException("Unknown Parking Space");
        }
        
        if (targetId.equals(booking.spaceId())){
            throw new IllegalArgumentException("Target must be different from current space");

        }
        if (!target.isOpen()){
            throw new IllegalArgumentException("Parking space not open");
        }
        if (target.isOccupied()){
            throw new IllegalArgumentException("Parking space is occupied");
        }
        String proposalId="P"+nextPropNum++;
        Proposal proposal = new Proposal(proposalId,booking.getId(),target.getId(),booking.getVersion(),policyVersion,"PENDING");
        proposals.add(proposal);
        return proposal.toView();
        
    }
    public String run(ModelProvider provider,int limit) {
        // TODO D2: validate protocol, dispatch tools, retain observation history,
        // bound invocations and stop at pending approval. No automatic commit.
        // Add separate operator approve/reject/execute operations and tick(time).
        throw new UnsupportedOperationException("D2 model/tool coordination");
    }
    // TODO D3: evolve policy, preserve regressions, refactor and specify contracts.
}
