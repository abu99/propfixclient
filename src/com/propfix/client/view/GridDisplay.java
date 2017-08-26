package com.propfix.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface GridDisplay<T> {
	HasClickHandlers getAddButton();
	HasClickHandlers getUpdateButton();
	HasClickHandlers getDeleteButton();
	HasClickHandlers getExtraButton();
	CustomGrid<T> getGrid();
}
