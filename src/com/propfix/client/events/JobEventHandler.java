/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 *
 * @author Y3850910
 */
public interface JobEventHandler extends EventHandler {
    void onViewJobs(JobEvent event);
}
