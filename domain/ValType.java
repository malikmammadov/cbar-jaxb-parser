package domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ValType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValType {

    @XmlAttribute(name = "Type")
    private String type;

    @XmlElement(name = "Valute")
    private List<Valute> valute;

    public String getType() {
        return type;
    }

    public List<Valute> getValute() {
        return valute;
    }
}
