public final class DomainRules {
    private DomainRules() {}
    public static void requireDuration(int hours) {
        // TODO D1: reject outside 1..24 with IllegalArgumentException.
        if ((hours<1)||(hours>24)){
            throw new IllegalArgumentException("duration can only be between 1 and 24 hours.");
        }
    }
    public static void requireIdentifier(String id) {
        // TODO D1: non-null [A-Z][A-Z0-9_-]{0,15}.
        if((id==null)||(!id.matches("[A-Z][A-Z0-9_-]{0,15}"))){
            throw new IllegalArgumentException("Invalid identfier added.");
        }
        
    }
}
