/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.events;


import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author Y3850910
 */
public class RegistrationEvent extends GwtEvent<RegistrationEventHandler> {

    public static Type<RegistrationEventHandler> TYPE = new 
            Type<RegistrationEventHandler>();
    @Override
    public Type<RegistrationEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RegistrationEventHandler handler) {
        handler.onRegister(this);
    }
    
}
