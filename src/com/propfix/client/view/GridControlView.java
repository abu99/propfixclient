package com.propfix.client.view;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

public class GridControlView<T> extends Composite implements GridDisplay<T> {
	private final MaterialButton addButton;
	private final MaterialButton updateButton;
	private final MaterialButton deleteButton;
	private final MaterialButton extraButton;
	
	private CustomGrid<T> dataTable;
	private final FlexTable contentTable;
	
	public GridControlView(CustomGrid<T> dataTable){
		this.dataTable = dataTable;
		
		MaterialRow contentTableDecorator = new MaterialRow();
		contentTableDecorator.setSize("100%", "100%");
	    initWidget(contentTableDecorator);
		MaterialRow master = new MaterialRow();
		contentTable = new FlexTable();
		contentTable.setCellSpacing(0);
		//create the menu
		MaterialPanel row = new MaterialPanel();
		row.setPaddingTop(10);
		row.setPaddingLeft(5);
		//row.setFloat(Float.LEFT);
		
		MaterialColumn column = new MaterialColumn();
		row.add(column);
		MaterialColumn column2 = new MaterialColumn();
		row.add(column2);
		MaterialColumn column3 = new MaterialColumn();
		row.add(column3);
		
		addButton = new MaterialButton(ButtonType.RAISED,"Add",new MaterialIcon(IconType.ADD));
		addButton.setIconPosition(IconPosition.LEFT);
		addButton.setWaves(WavesType.LIGHT);
		column.add(addButton);
		
		updateButton = new MaterialButton(ButtonType.RAISED,"Update",new MaterialIcon(IconType.EDIT));
		updateButton.setIconPosition(IconPosition.LEFT);
		updateButton.setWaves(WavesType.LIGHT);
		//updateButton.setStyleName("saveButton");
		column2.add(updateButton);
	
		
		deleteButton = new MaterialButton(ButtonType.RAISED,"Delete",new MaterialIcon(IconType.DELETE));
		deleteButton.setIconPosition(IconPosition.LEFT);
		deleteButton.setWaves(WavesType.LIGHT);
		//deleteButton.setStyleName("saveButton");
		column3.add(deleteButton);
		
		extraButton = new MaterialButton(ButtonType.FLOATING,"Extra",new MaterialIcon(IconType.EXIT_TO_APP));
		extraButton.setStyleName("saveButton");
		extraButton.setWaves(WavesType.LIGHT);
		extraButton.setVisible(false);
		column.add(extraButton);
		
		//contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
	    MaterialRow tableRow = new MaterialRow();
	    tableRow.setPaddingLeft(10);
	    tableRow.setPaddingRight(20);
	    tableRow.add(dataTable);
	    
	    master.add(row);
	    contentTable.setWidget(1, 0, tableRow);
		master.add(contentTable);
	    contentTableDecorator.add(master);
	}
	
	public HasData<T> getCellTable() {
		  return dataTable.getGrid();
	      }

	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public HasClickHandlers getUpdateButton() {
		return updateButton;
	}

	@Override
	public HasClickHandlers getDeleteButton() {
		return deleteButton;
	}
	
	@Override
	public HasClickHandlers getExtraButton(){
		return extraButton;
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}
	
	public void setAddButtonText(String text){
		this.addButton.setText(text);
	}
	
	public void setUpdateButtonText(String text){
		this.updateButton.setText(text);
	}
	
	public void setDeleteButtonText(String text){
		this.deleteButton.setText(text);
	}
	
	public void setExtraButtonText(String text){
		this.extraButton.setText(text);
	}
	
	public void setExtraButtonVisible(){
		extraButton.setVisible(true);
	}
	
	public void hideUpdateButton(){
		this.updateButton.setVisible(false);
	}
	
	public void hideAddButton(){
		this.addButton.setVisible(false);
	}
	
	public void hideDeleteButton(){
		this.deleteButton.setVisible(false);
	}

	@Override
	public CustomGrid<T> getGrid() {
		return dataTable;
	}
	

}
