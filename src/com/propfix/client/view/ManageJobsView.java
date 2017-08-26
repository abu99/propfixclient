
package com.propfix.client.view;

import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialRow;
import java.util.LinkedHashMap;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.propfix.client.dto.JobDto;
import com.propfix.client.presenter.ManageJobsPresenter;
import com.propfix.client.view.widget.DataType;

public class ManageJobsView extends Composite implements ManageJobsPresenter.Display {

    private final GridControlView<JobDto> grid;
    private final EditJobView view;

    public ManageJobsView() {
        MaterialRow vPanel = new MaterialRow();
        initWidget(vPanel);

        final MaterialCard card = new MaterialCard();
        card.setVisible(false);
        card.setLayoutPosition(Position.RELATIVE);
        card.setWidth("40%");
        MaterialCardContent content = new MaterialCardContent();
        card.add(content);
        view = new EditJobView();
        vPanel.add(view);
        
        grid = build();
        vPanel.add(grid);
    }

    private GridControlView<JobDto> build() {
        
        TextColumn<JobDto> jobId
                = new TextColumn<JobDto>() {
            @Override
            public String getValue(JobDto object) {
                return object.getJob();
            }
        };

        TextColumn<JobDto> description
                = new TextColumn<JobDto>() {

            @Override
            public String getValue(JobDto object) {
                return object.getDescription();
            }
        };
        LinkedHashMap<String, Column> columns = new LinkedHashMap<String, Column>();
        columns.put("Job", jobId);
        columns.put("Description", description);
        
        CustomGrid<JobDto> customGrid = new CustomGrid<JobDto>(columns,
                SelectionMode.SINGLE, false, true, DataType.STATIC);
        return new GridControlView<JobDto>(customGrid);
    }

    @Override
    public GridControlView<JobDto> getControlGrid() {
        return grid;
    }

    @Override
    public EditJobView getEditView() {
        return view;
    }
    
}
