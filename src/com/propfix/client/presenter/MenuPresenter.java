package com.propfix.client.presenter;

import com.google.gwt.event.shared.SimpleEventBus;
import com.propfix.client.EventManager;
import com.propfix.client.dto.PrivilegeDto;
import com.propfix.client.events.JobEvent;
import com.propfix.client.events.ManageFaultsEvent;
import com.propfix.client.events.ProfileEvent;
import com.propfix.client.events.RegistrationEvent;

public class MenuPresenter {

    private static SimpleEventBus eventBus = EventManager.getEventBus();

    public static void doNavigate(PrivilegeDto privilege) {
        if (privilege.getDescription().equals("Profile")) {
            eventBus.fireEvent(new ProfileEvent());
        } else if (privilege.getDescription().equals("Register")) {
            eventBus.fireEvent(new RegistrationEvent());
        }
        else if (privilege.getDescription().equals("My Jobs")) {
            eventBus.fireEvent(new JobEvent());
        }
        else if (privilege.getDescription().equals("Faults")) {
            eventBus.fireEvent(new ManageFaultsEvent());
        }
    }
}
