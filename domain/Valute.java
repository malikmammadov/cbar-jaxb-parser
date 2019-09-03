package domain;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {

    @XmlAttribute(name = "Code")
    private String code;

    @XmlElement(name = "Nominal")
    private String nominal;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    private BigDecimal value;

    public String getCode() {
        return code;
    }

    public String getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    private DecimalFormat decimalFormat = new DecimalFormat("0.0000");

    @Override
    public String toString() {
        return String.format("%45s %20s %20s %20s", name, nominal, code, decimalFormat.format(value));
    }
}
