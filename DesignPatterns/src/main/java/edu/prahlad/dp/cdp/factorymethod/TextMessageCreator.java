package edu.prahlad.dp.cdp.factorymethod;

import edu.prahlad.dp.cdp.factorymethod.message.Message;
import edu.prahlad.dp.cdp.factorymethod.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
