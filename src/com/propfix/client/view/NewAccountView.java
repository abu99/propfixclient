/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.propfix.client.LoginPage;
import com.propfix.client.presenter.NewAccountPresenter;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;

/**
 *
 * @author Y3850910
 */

public class NewAccountView extends Composite implements NewAccountPresenter.Display {
    
    private final MaterialListBox propType;
    private final MaterialTextBox userId;
    private final MaterialTextBox surname;
    private final MaterialTextBox firstName;
    private final MaterialTextBox password;
    private final MaterialTextBox password2;
    private final MaterialTextBox middleName;
    private final MaterialTextBox email;
    private final MaterialRadioButton male;
    private final MaterialRadioButton female;
    private final MaterialButton saveButton;
    private final MaterialTextBox propId;
    private final LoginPage loginView;
    
    public NewAccountView() {
        MaterialRow main = new MaterialRow();
        initWidget(main);
        
        userId = new MaterialTextBox();
        userId.setPlaceholder("Select new Username");
        
        surname = new MaterialTextBox();
        surname.setPlaceholder("Your Surname");
        
        propType = new MaterialListBox();
        propType.addItem("Tenant");
        propType.addItem("Contractor");
        
        firstName = new MaterialTextBox();
        firstName.setPlaceholder("Your first Name");
        
        
        middleName = new MaterialTextBox();
        middleName.setPlaceholder("Your Middle Name");
        
        email = new MaterialTextBox();
        email.setPlaceholder("Your email address");
        
        male = new MaterialRadioButton("", "Male");
        female = new MaterialRadioButton("", "Female");
        
        propId = new MaterialTextBox();
        propId.setPlaceholder("Property ID");
        
        password = new MaterialTextBox();
        password.setPlaceholder("Choose Password");
        password2 = new MaterialTextBox();
        password2.setPlaceholder("Confirm Password");
        
        saveButton = new MaterialButton(
                ButtonType.RAISED, "Create Account", new MaterialIcon(IconType.EDIT));
        saveButton.setWaves(WavesType.LIGHT);
        saveButton.setIconPosition(IconPosition.LEFT);
        
        loginView = new LoginPage();
        
        MaterialColumn registerColumn = new MaterialColumn();
        registerColumn.setWidth("50%");
        
        registerColumn.add(userId);
        registerColumn.add(surname);
        registerColumn.add(firstName);
        registerColumn.add(middleName);
        registerColumn.add(email);
        registerColumn.add(password);
        registerColumn.add(password2);
        
        MaterialRow row = new MaterialRow();
        row.add(propType);
        registerColumn.add(propId);
        registerColumn.add(row);
        registerColumn.add(new MaterialRow());
        registerColumn.add(saveButton);
        
        MaterialColumn loginCol = new MaterialColumn();
//        loginCol.add(loginView);
        
//        main.add(loginCol);
        main.add(registerColumn);
    }
    
    
    @Override
    public MaterialTextBox getSurName() {
        return surname;
    }
    @Override
    public MaterialListBox getPropType() {
        return propType;
    }

    @Override
    public MaterialTextBox getFirstName() {
        return firstName;
    }

    @Override
    public MaterialTextBox getMiddleName() {
        return middleName;
    }

    @Override
    public MaterialRadioButton getFemaleGender() {
        return male;
    }

    @Override
    public MaterialRadioButton getMaleGender() {
        return female;
    }

    @Override
    public MaterialTextBox getEmal() {
        return email;
    }

    @Override
    public MaterialTextBox getPropId() {
        return propId;
    }

    @Override
    public MaterialButton getSaveButton() {
        return saveButton;
    }

    @Override
    public MaterialTextBox getPassword() {
        return password;
    }

    @Override
    public MaterialTextBox getPassword2() {
        return password2;
    }
    
    @Override
    public MaterialTextBox getUserName() {
        return userId;
    }

    @Override
    public LoginPage getLoginView() {
        return loginView;
    }
    
}
