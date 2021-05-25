package backend;

public class Bild {

    // Default Integer is NULL
    private final Integer bildId;
    private final Integer fachId;
    private final String fachBild;
    private final String richtigBild;
    private final String falschBild;

    public Bild(Integer bildId, Integer fachId, String fachBild, String richtigBild, String falschBild) {
        this.bildId = bildId;
        this.fachId = fachId;
        this.fachBild = fachBild;
        this.richtigBild = richtigBild;
        this.falschBild = falschBild;
    }

    public Integer getBildId() {
        return bildId;
    }

    public Integer getFachId() {
        return fachId;
    }

    public String getFachBild() {
        return fachBild;
    }

    public String getRichtigBild() {
        return richtigBild;
    }

    public String getFalschBild() {
        return falschBild;
    }

    @Override
    public String toString() {
        return "Bild{" +
                "bildId=" + bildId +
                ", fachId=" + fachId +
                ", fachBild='" + fachBild + '\'' +
                ", richtigBild='" + richtigBild + '\'' +
                ", falschBild='" + falschBild + '\'' +
                '}';
    }
}
