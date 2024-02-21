package Pages.ProductPage;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FeaturesTitles {
    @ToString.Include
    public String ANALYZE(){return "ANALYZE";}
    @ToString.Include
    public String PRIORITIZE(){return "PRIORITIZE";}
    @ToString.Include
    public String ACT(){return "ACT";}

}
