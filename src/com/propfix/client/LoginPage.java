/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;


public class LoginPage extends Composite {


    MaterialTextBox userName = new MaterialTextBox();
    MaterialTextBox txtPassword = new MaterialTextBox();
    MaterialButton btnLogin = new MaterialButton();
    MaterialButton createAcc = new MaterialButton();
    
    public LoginPage () {
        MaterialPanel main = new MaterialPanel();
        MaterialPanel buttonPanel = new MaterialPanel();
        
        main.setWidth("50%");
        buttonPanel.setWidth("20%");
        initWidget(main);
        
        userName.setIconType(IconType.EMAIL);
        
        txtPassword.setType(InputType.PASSWORD);
        txtPassword.setIconType(IconType.SECURITY);

        btnLogin.setText("Login");
        btnLogin.setBackgroundColor("blue");
        btnLogin.setWaves(WavesType.DEFAULT);
        
        createAcc.setText("sign up");
        createAcc.setBackgroundColor("red");
        createAcc.setWaves(WavesType.DEFAULT);
        
        main.add(userName);
        main.add(txtPassword);
        buttonPanel.add(createAcc);
        buttonPanel.add(btnLogin);
        main.add(buttonPanel);
        
        btnLogin.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                loadData();
            }
        });
    }
    private void loadData() {
        if (userName.getValue().isEmpty()) {
            MaterialToast.fireToast("Please input user and password");
            return;
        }
        MaterialToast.fireToast("LoggedIn successfully");
    }
}
