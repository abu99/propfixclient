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
import com.propfix.client.LoginPage;
import com.propfix.client.dto.UserDto;
import com.propfix.client.resty.UserService;
import com.propfix.client.view.widget.ContentHeader;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author Y3850910
 */
public class NewAccountPresenter implements Presenter {
   
    private Display display;

    public NewAccountPresenter(Display display) {
        this.display = display;
        ContentHeader.get().setTitle("Create new Account");
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
        display.getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                UserDto user = new UserDto();
                user.setPassword(display.getPassword().getValue());
//                user.setUserType(UserTypeDto.valueOf(display.getPropType().getSelectedValue()));
                user.setUsername(display.getUserName().getValue());
                save(user);
            }
        });
        
    }

    private void save(UserDto user) {
        UserService.Util.get().getAll(new MethodCallback<UserDto>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                MaterialToast.fireToast(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, UserDto response) {
                MaterialToast.fireToast("Saved");
            }
        });
    }
    public interface Display {
        Widget asWidget();
        MaterialTextBox getUserName();
        MaterialTextBox getSurName();
        MaterialListBox getPropType();
        MaterialTextBox getPassword();
        MaterialTextBox getPassword2();
        MaterialTextBox getFirstName();
        MaterialTextBox getMiddleName();
        MaterialRadioButton getFemaleGender();
        MaterialRadioButton getMaleGender();
        MaterialTextBox getEmal();
        MaterialTextBox getPropId();
        MaterialButton getSaveButton();
        LoginPage getLoginView();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
