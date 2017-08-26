/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.propfix.client.dto.JobDto;
import com.propfix.client.view.EditJobView;
import com.propfix.client.view.GridControlView;
import com.propfix.client.view.widget.ContentHeader;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Y3850910
 */
public class ManageJobsPresenter implements Presenter {
    
    private Display display;

    public ManageJobsPresenter(Display display) {
        this.display = display;
        ContentHeader.get().setTitle("My Jobs - Contractor");
        display.getControlGrid().hideUpdateButton();
        display.getControlGrid().hideAddButton();
        bind();
    }
    private void bind () {
        display.getEditView().getSave().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (display.getEditView().getDescription().getValue().isEmpty()) {
                    MaterialToast.fireToast("Please enter the id and description to continue");
                    return;
                }
                JobDto job = new JobDto(display.getEditView().getList().getSelectedValue(), 
                        display.getEditView().getDescription().getValue());
                display.getControlGrid().getGrid().addData(job);
            }
        });
        display.getControlGrid().getAddButton()
                .addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                
            }
        });
    }
    private void loadJobs() {
        
        List<JobDto> jobs = new ArrayList<JobDto>();
        
        for (int i = 0; i < 23; i ++) {
            JobDto job = new JobDto();
            job.setDescription("This is job one");
            job.setJob("Job Name " + i + 1);
            
            jobs.add(job);
        }
        display.getControlGrid().getGrid().setData(jobs);
    }
    
    public interface Display {
        Widget asWidget();
        GridControlView<JobDto> getControlGrid();
        EditJobView getEditView();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
