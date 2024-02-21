package Pages.ProductPage.XtagSection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class XtagHeaderText {
    @ToString.Include
    public String headerText(){return "x_tags™ help prioritize threats using contextual scoring, like prioritization parameters, access authority and activity status in order to determine the risk level of every application and asset in your organization.";}
    @ToString.Include
    public String headerTitle(){return "x_tags™\nContextual Protection";}
}
