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
public class ManageFaultsEvent1 extends GwtEvent<ManageFaultsEventHandler1> {

    public static Type<ManageFaultsEventHandler1> TYPE = new 
            Type<ManageFaultsEventHandler1>();
    @Override
    public Type<ManageFaultsEventHandler1> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ManageFaultsEventHandler1 handler) {
        handler.onViewFaults(this);
    }
    
}
