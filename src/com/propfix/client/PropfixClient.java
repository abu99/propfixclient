package com.propfix.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.propfix.client.dto.PrivilegeDto;
import com.propfix.client.dto.RoleDto;
import com.propfix.client.view.AppLayoutView;
import com.propfix.client.view.CenterView;
import com.propfix.client.view.widget.LeftSideMenu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PropfixClient implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
        @Override
	public void onModuleLoad() {
		SimpleEventBus eventBus = EventManager.getEventBus();
		AppController appViewer = new AppController(eventBus);
		
		cacheObjects();
		
		Element body = Document.get().getBody();
		Element loading = Document.get().getElementById("loading");
		if(body.isOrHasChild(loading)){
			loading.removeFromParent();
		}
		
		setUp(appViewer);
	}
	
	private void setUp(final AppController appViewer){

		
		LeftSideMenu.get().createMenus(getDummyList());
		
		RootLayoutPanel.get().add(AppLayoutView.get());
		appViewer.go(CenterView.get());
		
	}
	
	private List<RoleDto> getDummyList(){
		List<RoleDto> roles = new ArrayList<>();
		
		
                PrivilegeDto profile = new PrivilegeDto();
		profile.setPrivilegeId(1);
		profile.setDescription("Profile");
		
                PrivilegeDto register = new PrivilegeDto();
		register.setPrivilegeId(2);
		register.setDescription("Register");
		
                PrivilegeDto job = new PrivilegeDto();
		job.setPrivilegeId(3);
		job.setDescription("My Jobs");
		
		PrivilegeDto faults = new PrivilegeDto();
		faults.setPrivilegeId(3);
		faults.setDescription("Faults");
		
		RoleDto role = new RoleDto();
		role.setRoleId(1);
		role.setDescription("Contractor");
		role.setRoleName("Contractor");
		List<PrivilegeDto> privileges = new ArrayList<>();
		
                
		privileges.add(register);
                privileges.add(profile);
		privileges.add(job);
		privileges.add(faults);
		
		role.setPrivileges(privileges);
		roles.add(role);
		
		return roles;
	}
	
	
	private void cacheObjects(){

	}
}
