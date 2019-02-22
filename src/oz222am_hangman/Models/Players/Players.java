package oz222am_hangman.Models.Players;


import oz222am_hangman.Models.Items;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Players.
 */
public class Players extends Items<Player> {

    /**
     * Instantiates a new Players.
     */
    Players() {
        super();
    }

    @Override
    public void load() throws Exception {
        List<Player> items = new ArrayList<>();
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(getPath());
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            Player item = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getName().getLocalPart().equals(getClass().getName().toLowerCase())) {
                        item = new Player();
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals("id")) {
                                item.setId(Integer.parseInt(attribute.getValue()));
                            }

                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals("name")) {
                            event = eventReader.nextEvent();
                            if (item != null) {
                                item.setName(event.asCharacters().getData());
                            }
                            continue;
                        }
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(getClass().getName().toLowerCase())) {
                        items.add(item);
                    }
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        add(items);
    }

    @Override
    public void save() throws Exception {

    }

    /**
     * Register player.
     *
     * @param name the name
     * @return the player
     * @throws Exception the exception
     */
    public Player register(String name) throws Exception {
        var player = new Player();
        player.setName(name);
        save();
        return super.add(player);
    }


}
