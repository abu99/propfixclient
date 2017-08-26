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
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Y3850910
 */
public class ManageFaultsPresenter2 implements Presenter {
    
    private Display display;

    public ManageFaultsPresenter2(Display display) {
        this.display = display;
        display.getControlGrid().setAddButtonText("Add Fault");
        display.getControlGrid().setDeleteButtonText("Cancel");
        display.getControlGrid().hideUpdateButton();
        ContentHeader.get().setTitle("Faults");
        loadFaults();
        bind();
    }
    private void bind() {
        display.getControlGrid().getDeleteButton()
                .addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                FaultDto selected = display.getControlGrid().getGrid().getSelectedObject();
                if (selected == null) {
                    MaterialToast.fireToast("Select a fault please");
                    return;
                }
                display.getControlGrid().getGrid().removeSelectedRow();
            }
        });
        display.getPrintButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (display.getSearchField().getValue().isEmpty()) {
                    MaterialToast.fireToast("Please input description");
                    return;
                }
                FaultDto faultDto = new FaultDto();
                faultDto.setDateCreated(new Date());
                faultDto.setDescription(display.getSearchField().getValue());
                faultDto.setFaultType(display.getFaultTypes().getSelectedValue());
                faultDto.setPropertyTypeId("Y3232090");
                faultDto.setStatus("Pending");
                
                display.getControlGrid().getGrid().addData(faultDto, 0);
            }
        });
        
        display.getControlGrid().getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                display.show(true);
            }
        });
        display.getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                display.show(false);
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
        MaterialTextBox getSearchField();
        MaterialListBox getFaultTypes();
        void show(boolean status);
        MaterialButton getPrintButton();
        MaterialButton getCancelButton();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
