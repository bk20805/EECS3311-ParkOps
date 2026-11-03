public final class Proposal{
    private final String proposalId;
    private final String bookingId;
    private final String targetId;
    private final int bookingVersion;
    private final int policyVersion;
    private final String status;

    public Proposal(String proposalId,String bookingId,String targetId,int bookingVersion,int policyVersion,String status){
        DomainRules.requireIdentifier(proposalId);
        DomainRules.requireIdentifier(bookingId);
        DomainRules.requireIdentifier(targetId);

        if((bookingVersion<0)||(policyVersion<0)){
            throw new IllegalArgumentException("booking or policy version cannot be negative");
        }
        if(!"PENDING".equals(status)){
            throw new IllegalArgumentException("A new proposal must be pending");
        }
        this.proposalId=proposalId;
        this.bookingId=bookingId;
        this.targetId=targetId;
        this.bookingVersion=bookingVersion;
        this.policyVersion=policyVersion;
        this.status=status;

    } 
    public String getProposalId(){
        return proposalId;
    }
    public String getBookingId(){
        return bookingId;
    }
    public String getTargetId(){
        return targetId;
    }
    public int getBookingVersion(){
        return bookingVersion;
    }
    public int getPolicyVersion(){
        return policyVersion;
    }
    public String getStatus(){
        return status;
    }
    public ProposalView toView(){
        return new ProposalView(proposalId,bookingId,targetId,bookingVersion,policyVersion,status);
    }
}