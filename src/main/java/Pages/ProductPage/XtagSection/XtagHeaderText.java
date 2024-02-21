package Pages.ProductPage.XtagsSection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class XtagHeaderText {
    @ToString.Include
    public String headerText(){return "vRx regularly analyzes high-risk third-party apps for CVEs and zero-day attacks.";}
}
