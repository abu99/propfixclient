/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.propfix.client.dto.FaultDto;
import com.propfix.client.view.GridControlView;
import com.propfix.client.view.widget.ContentHeader;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Y3850910
 */
public class ManageFaultsPresenter implements Presenter {
    
    private Display display;

    public ManageFaultsPresenter(Display display) {
        this.display = display;
        display.getControlGrid().setAddButtonText("Accept/Cancel");
        display.getControlGrid().setUpdateButtonText("Complete");
        display.getControlGrid().setDeleteButtonText("Cancel");
        ContentHeader.get().setTitle("Faults");
        loadFaults();
        bind();
    }
    private void bind() {
        display.getControlGrid().getDeleteButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                
                if (display.getControlGrid().getGrid().getSelectedObject() == null) {
                    MaterialToast.fireToast("Select fault to cancel");
                    return;
                }
                FaultDto data = display.getControlGrid().getGrid().getSelectedObject();
                data.setStatus("Cancelled");
                display.getControlGrid().getGrid().updateSelectedData(data);
            }
        });
        display.getControlGrid().getUpdateButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                
                if (display.getControlGrid().getGrid().getSelectedObject() == null) {
                    MaterialToast.fireToast("Select fault to update");
                    return;
                }
                FaultDto data = display.getControlGrid().getGrid().getSelectedObject();
                data.setStatus("Completed");
                display.getControlGrid().getGrid().updateSelectedData(data);
            }
        });
        display.getControlGrid().getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                
                if (display.getControlGrid().getGrid().getSelectedObject() == null) {
                    MaterialToast.fireToast("Select fault to update");
                    return;
                }
                if (display.getControlGrid().getGrid().getSelectedObject()
                        .getStatus().equals("Pending")) {
                    FaultDto data = display.getControlGrid().getGrid().getSelectedObject();
                    data.setStatus("In Progress");
                    display.getControlGrid().getGrid().updateSelectedData(data);
                } else {
                    FaultDto data = display.getControlGrid().getGrid().getSelectedObject();
                    data.setStatus("Pending");
                    display.getControlGrid().getGrid().updateSelectedData(data);
                }
            }
        });
    }
    private void loadFaults() {
        
        List<FaultDto> faults = new ArrayList<FaultDto>();
        
        for (int i = 0; i < 3; i ++) {
            FaultDto job = new FaultDto();
            job.setDescription("This is job one");
            job.setDateCreated(new Date());
            job.setFaultType("Electricity");
            job.setPropertyTypeId("Y323209" + i);
            job.setStatus("Pending");
            
            faults.add(job);
        }
        display.getControlGrid().getGrid().setData(faults);
    }
    
    public interface Display {
        Widget asWidget();
        GridControlView<FaultDto> getControlGrid();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
