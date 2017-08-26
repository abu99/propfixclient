/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.events;


import com.google.gwt.event.shared.GwtEvent;

public class JobEvent extends GwtEvent<JobEventHandler> {

    public static Type<JobEventHandler> TYPE = new 
            Type<JobEventHandler>();
    @Override
    public Type<JobEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(JobEventHandler handler) {
        handler.onViewJobs(this);
    }
    
}
