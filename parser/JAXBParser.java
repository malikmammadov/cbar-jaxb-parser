package parser;

import domain.ValCurs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JAXBParser {

    public static final String URL = "https://www.cbar.az/currencies/"
            + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".xml";

    public static void main(String[] args) {
        try {

            URL url = new URL(URL);
            JAXBContext context = JAXBContext.newInstance(ValCurs.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            ValCurs valCurs = (ValCurs) unmarshaller.unmarshal(url);


            System.out.println(valCurs.getDate() + " " + valCurs.getName() + "\n"
                    + valCurs.getDescription());
            valCurs.getValType().forEach(valType -> {
                System.out.println("Type" + String.format("%41s %20s %20s %21s", "Currency", "Nominal", "Code", "Value\n"));
                System.out.println(valType.getType());
                valType.getValute().forEach(System.out::println);
            });

//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(valCurs, System.out);
        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
