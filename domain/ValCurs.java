package domain;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.StringJoiner;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlAttribute(name = "Description")
    private String description;

    @XmlElement(name = "ValType")
    private List<ValType> valType;

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ValType> getValType() {
        return valType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ValCurs.class.getSimpleName() + "[", "]")
                .add("date='" + date + "'")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("valType=" + valType)
                .toString();
    }
}
