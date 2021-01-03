package edu.prahlad.dp.cdp.factorymethod;

import edu.prahlad.dp.cdp.factorymethod.message.Message;

/**
 * This is our abstract "creator".
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {
    public Message getMessage(){
        Message message = createMessage();
        message.addDefaultHeaders();;
        message.encrypt();
        return message;
    }

    //Factory Method
    public abstract Message createMessage();
}
