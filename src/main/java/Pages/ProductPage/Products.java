package Pages.ProductPage;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Products {

    @ToString.Include
    public String overview(){return "Product Overview";}
    @ToString.Include
    public String vulnerability(){return "Vulnerability Management";}
    @ToString.Include
    public String x_tags(){return "x_tags";}
    @ToString.Include
    public String zeroDays(){return "0-Day Detection";}
    @ToString.Include
    public String reporting(){return "Reporting";}
    @ToString.Include
    public String network(){return "Network Scanner";}
    @ToString.Include
    public String patch(){return "Patch Management";}
    @ToString.Include
    public String patchless(){return "Patchless Protection";}
    @ToString.Include
    public String auto(){return "Auto Actions";}
    @ToString.Include
    public String user(){return "User Management";}
}
