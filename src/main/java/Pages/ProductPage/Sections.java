package Pages.ProductPage;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Sections {
    @ToString.Include
    public String features(){return "features";}
    @ToString.Include
    public String proposition(){return "proposition";}
    @ToString.Include
    public String xtags(){return "xtags";}
    @ToString.Include
    public String protection(){return "protection";}
    @ToString.Include
    public String demos(){return "demos";}
}
