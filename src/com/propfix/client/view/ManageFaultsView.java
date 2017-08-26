
package com.propfix.client.view;

import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialRow;
import java.util.LinkedHashMap;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.propfix.client.dto.FaultDto;
import com.propfix.client.presenter.ManageFaultsPresenter;
import com.propfix.client.view.widget.DataType;

public class ManageFaultsView extends Composite implements ManageFaultsPresenter.Display {

    private final GridControlView<FaultDto> grid;
//    private final MaterialListBox actions;

    public ManageFaultsView() {
        MaterialRow vPanel = new MaterialRow();
        initWidget(vPanel);

        final MaterialCard card = new MaterialCard();
        card.setVisible(false);
        card.setLayoutPosition(Position.RELATIVE);
        card.setWidth("40%");
        MaterialCardContent content = new MaterialCardContent();
        grid = build();
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
//    public MaterialListBox getActionList() {
//        return actions;
//    }
}
