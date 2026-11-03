import java.util.Map;

public final class Booking{
    private final String id;
    private final String spaceId;
    private final int durationHours;
    private final int version;
    private final boolean requiresAccess;
    
    public Booking(String id, String spaceId, int durationHours, int version, boolean requiresAccess){
        DomainRules.requireIdentifier(id);
        DomainRules.requireIdentifier(spaceId);
        DomainRules.requireDuration(durationHours);

        if (version<0){
            throw new IllegalArgumentException("Booking version cannot be negative");
        }
        this.id=id;
        this.spaceId=spaceId;
        this.durationHours=durationHours;
        this.version=version;
        this.requiresAccess=requiresAccess;
    }
    public String getId(){
        return id;

    }
    public String spaceId(){
        return spaceId;
    }
    public int getDurationHours(){
        return durationHours;
    }
    public int getVersion(){
        return version;
    }
    public boolean requiresAccess(){
        return requiresAccess;
    }
    public Map<String,Object>snapshot(){
        return Map.of("id", id, "spaceId", spaceId, "durationHours", durationHours, "version", version, "requiresAccess", requiresAccess);

    }


}
