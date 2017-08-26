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
public class ProfileEvent extends GwtEvent<ProfileEventHandler> {

    public static Type<ProfileEventHandler> TYPE = new 
            Type<ProfileEventHandler>();
    @Override
    public Type<ProfileEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ProfileEventHandler handler) {
        handler.onViewPrifile(this);
    }
    
}
