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
import com.propfix.client.cache.CacheManager;
import com.propfix.client.view.widget.ContentHeader;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

/**
 *
 * @author Y3850910
 */
public class ProfilePresenter implements Presenter {
   
    private Display display;

    public ProfilePresenter(Display display) {
        
        this.display = display;
        
        ContentHeader.get().setTitle("Profile Settings");
        bind();
    }
    private void bind () {
        display.getFemaleGender().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                display.getMaleGender().setValue(false);
            }
        });
        display.getMaleGender().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                display.getFemaleGender().setValue(false);
            }
        });
        
    }
    public interface Display {
        Widget asWidget();
        MaterialTextBox getSurnameText();
        MaterialTextBox getFirstName();
        MaterialTextBox getMiddleName();
        MaterialRadioButton getFemaleGender();
        MaterialRadioButton getMaleGender();
        MaterialTextBox getEmal();
        MaterialTextBox getPropId();
        MaterialButton getSaveButton();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
