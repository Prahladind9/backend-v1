package edu.prahlad.dp.cdp.factorymethod;

import edu.prahlad.dp.cdp.factorymethod.message.JSONMessage;
import edu.prahlad.dp.cdp.factorymethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
