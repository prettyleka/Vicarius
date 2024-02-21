package Pages.ProductPage.PropositionSection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UseCaseText {
    @ToString.Include
    public String Analyze(){return "vRx regularly analyzes high-risk third-party apps for CVEs and zero-day attacks.";}
    @ToString.Include
    public String Monitor(){return "vRx continuously monitors vulnerabilities and reports any exploitation attempts.";}
    @ToString.Include
    public String Protect(){return "vRx actively protects against threats and blocks exploitation attempts and attacks.";}
}
