package Pages.ProductPage.ProtectionSection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProtectionSectionTexts {
    @ToString.Include
    public String headerTitle(){return "0-day Detection";}
    @ToString.Include
    public String subheaderTitle(){return "Real-time Threat Prediction";}
    @ToString.Include
    public String headerText(){return "vRx's 0-Day Analysis™ uses a proactive approach that continuously analyzes, predicts and identifies novel binary-level threats. Don't wait for your software to get hacked. Protect your organization with vRx.";}
}
