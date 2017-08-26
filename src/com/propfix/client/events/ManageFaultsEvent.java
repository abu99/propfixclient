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
public class ManageFaultsEvent extends GwtEvent<ManageFaultsEventHandler> {

    public static Type<ManageFaultsEventHandler> TYPE = new 
            Type<ManageFaultsEventHandler>();
    @Override
    public Type<ManageFaultsEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ManageFaultsEventHandler handler) {
        handler.onViewFaults(this);
    }
    
}
