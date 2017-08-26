/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.propfix.client.view;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Y3850910
 */
public class EditJobView extends Composite {
    
    private final MaterialButton save;
    private final MaterialListBox id;
    private final MaterialTextBox description;
            
    public EditJobView() {
        
        MaterialRow row = new MaterialRow();
        initWidget(row);
        
        id = new MaterialListBox();
        
        for (String str : getJobTypes()) {
            id.addItem(str);
        }
        
        id.setPlaceholder("Job");
        
        description = new MaterialTextBox();
        description.setPlaceholder("Description");
        
        save = new MaterialButton(ButtonType.RAISED, 
                "Save",new MaterialIcon(IconType.ADD));
        
        MaterialColumn column = new MaterialColumn();
        column.add(id);
        
        MaterialColumn column1 = new MaterialColumn();
        
        column1.add(description);
        
        MaterialColumn column2 = new MaterialColumn();
        
        column2.add(save);
        
        row.add(column);
        row.add(column1);
        row.add(column2);
    }
    public MaterialListBox getList() {
        return id;
    }
    public MaterialTextBox getDescription() {
        return description;
    }
    public MaterialButton getSave() {
        return save;
    }
    public List<String> getJobTypes() {
        List<String> list = new ArrayList<>();
        list.add("Electricity");
        list.add("Plumbing");
        list.add("General maintenance");
        return list;
    }
}
