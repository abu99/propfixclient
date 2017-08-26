package com.propfix.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.propfix.client.events.JobEvent;
import com.propfix.client.events.JobEventHandler;
import com.propfix.client.events.ManageFaultsEvent;
import com.propfix.client.events.ManageFaultsEvent1;
import com.propfix.client.events.ManageFaultsEventHandler;
import com.propfix.client.events.ManageFaultsEventHandler1;
import com.propfix.client.events.ProfileEvent;
import com.propfix.client.events.ProfileEventHandler;
import com.propfix.client.events.RegistrationEvent;
import com.propfix.client.events.RegistrationEventHandler;
import com.propfix.client.presenter.ManageFaultsPresenter;
import com.propfix.client.presenter.ManageFaultsPresenter2;
import com.propfix.client.presenter.ManageJobsPresenter;
import com.propfix.client.presenter.NewAccountPresenter;
import com.propfix.client.presenter.Presenter;
import com.propfix.client.presenter.ProfilePresenter;
import com.propfix.client.view.ManageFaultsView;
import com.propfix.client.view.ManageFaultsView2;
import com.propfix.client.view.ManageJobsView;
import com.propfix.client.view.NewAccountView;
import com.propfix.client.view.ProfileView;

public class AppController implements Presenter, ValueChangeHandler<String>{
	private final SimpleEventBus eventBus;
	private HasWidgets container;
	
	public AppController(SimpleEventBus eventBus) {
		this.eventBus = eventBus;
		bind();
	}
	
	private void bind(){
            History.addValueChangeHandler(this);
            eventBus.addHandler(ProfileEvent.TYPE, new ProfileEventHandler() {
                @Override
                public void onViewPrifile(ProfileEvent event) {
                    History.newItem("profile");
                }
            });
            eventBus.addHandler(RegistrationEvent.TYPE, new RegistrationEventHandler() {
                @Override
                public void onRegister(RegistrationEvent event) {
                    History.newItem("registration");
                }
            });
            eventBus.addHandler(JobEvent.TYPE, new JobEventHandler() {
                @Override
                public void onViewJobs(JobEvent event) {
                    History.newItem("jobs");
                }
            });
            eventBus.addHandler(ManageFaultsEvent.TYPE, new ManageFaultsEventHandler() {
                @Override
                public void onViewFaults(ManageFaultsEvent event) {
                    History.newItem("faults");
                }
            });
            eventBus.addHandler(ManageFaultsEvent1.TYPE, new ManageFaultsEventHandler1() {
                @Override
                public void onViewFaults(ManageFaultsEvent1 event) {
                    History.newItem("faults2");
                }
            });
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		navigate(event);
	}
	
        public void navigate(ValueChangeEvent<String> event) {
            
            String token = event.getValue();

            if (token != null) {

                Presenter presenter = new ProfilePresenter(new ProfileView());
                
                
                if (token.equals("profile")) {
                    presenter = new ProfilePresenter(new ProfileView());
                }
                if (token.equals("registration")) {
                    presenter = new NewAccountPresenter(new NewAccountView());
                }
                if (token.equals("jobs")) {
                    presenter = new ManageJobsPresenter(new ManageJobsView());
                }
                if (token.equals("faults")) {
                    presenter = new ManageFaultsPresenter(new ManageFaultsView());
                }
                if (token.equals("faults2")) {
                    presenter = new ManageFaultsPresenter2(new ManageFaultsView2());
                }

                if (presenter != null) {
                    presenter.go(container);
                }
            }
    }
	

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		if ("".equals(History.getToken())) {
	         History.newItem("main page");
	         
	        } else {
	            History.fireCurrentHistoryState();
	        }
	}
}
