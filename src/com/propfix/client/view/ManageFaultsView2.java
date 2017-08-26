package com.propfix.client.view;

import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialRow;
import java.util.LinkedHashMap;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.propfix.client.dto.FaultDto;
import com.propfix.client.presenter.ManageFaultsPresenter2;
import com.propfix.client.util.ErrorRemover;
import com.propfix.client.view.widget.DataType;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialTextBox;

public class ManageFaultsView2 extends Composite implements ManageFaultsPresenter2.Display {

    private final GridControlView<FaultDto> grid;
    private final MaterialTextBox description;
    private final MaterialListBox faultTypes;
    private MaterialButton searchButton;
    private MaterialButton resetButton;
    private final MaterialCard card;

    public ManageFaultsView2() {
        MaterialRow vPanel = new MaterialRow();
        initWidget(vPanel);
        card = new MaterialCard();
        card.setVisible(false);
//        card.setLayoutPosition(Position.RELATIVE);
        card.setWidth("50%");
        card.setHeight("50px");
        MaterialCard content = new MaterialCard();
//        content.set
        grid = build();
        MaterialRow searchRow = new MaterialRow();
        searchRow.setWidth("100");
//        searchRow.setPaddingLeft(10);
        card.add(content);
        
        faultTypes = new MaterialListBox();
        faultTypes.addItem("Electricity");
        faultTypes.addItem("Plumbing");
        faultTypes.addItem("General Maintenance");
        
        description = new MaterialTextBox();
        description.setPlaceholder("Description");
        description.addKeyUpHandler(new ErrorRemover());
        searchButton = new MaterialButton(ButtonType.RAISED, "Submit Fault", new MaterialIcon(IconType.ADD));
        resetButton = new MaterialButton(ButtonType.RAISED, "Cancel", new MaterialIcon(IconType.REFRESH));

        content.add(description);
        
        content.add(faultTypes);
        content.add(searchButton);
        content.add(resetButton);
        searchRow.add(card);
        
        vPanel.add(searchRow);
        vPanel.add(grid);
    }

    private GridControlView<FaultDto> build() {

        TextColumn<FaultDto> propType
                = new TextColumn<FaultDto>() {
            @Override
            public String getValue(FaultDto object) {
                return object.getPropertyTypeId();
            }
        };
        TextColumn<FaultDto> faultType
                = new TextColumn<FaultDto>() {
            @Override
            public String getValue(FaultDto object) {
                return object.getFaultType();
            }
        };

        TextColumn<FaultDto> description
                = new TextColumn<FaultDto>() {

            @Override
            public String getValue(FaultDto object) {
                return object.getDescription();
            }
        };
        TextColumn<FaultDto> date
                = new TextColumn<FaultDto>() {

            @Override
            public String getValue(FaultDto object) {
                return object.getDateCreated().toString();
            }
        };
        TextColumn<FaultDto> status
                = new TextColumn<FaultDto>() {

            @Override
            public String getValue(FaultDto object) {
                return object.getStatus();
            }
        };
        
        LinkedHashMap<String, Column> columns = new LinkedHashMap<String, Column>();
        columns.put("Property Type ID", propType);
        columns.put("Fault Type", faultType);
        columns.put("Description", description);
        columns.put("Date Created", date);
        columns.put("Status", status);

        CustomGrid<FaultDto> customGrid = new CustomGrid<FaultDto>(columns,
                SelectionMode.SINGLE, false, true, DataType.STATIC);
        return new GridControlView<FaultDto>(customGrid);
    }

    @Override
    public GridControlView<FaultDto> getControlGrid() {
        return grid;
    }
    
    @Override
    public MaterialButton getPrintButton() {
        return searchButton;
    }

    @Override
    public MaterialButton getCancelButton() {
        return resetButton;
    }

    @Override
    public MaterialTextBox getSearchField() {
        return description;
    }

    @Override
    public void show(boolean status) {
        card.setVisible(status);
    }

    @Override
    public MaterialListBox getFaultTypes() {
        return faultTypes;
    }
}
