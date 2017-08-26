
package com.propfix.client.resty;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;
import com.propfix.client.dto.JobTypeDto;

public interface JobTypeService extends RestService{

	@POST
	void create(JobTypeDto jobType, MethodCallback<JobTypeDto> callback);

	@PUT
	void update(JobTypeDto jobType, MethodCallback<JobTypeDto> callback);

	@GET
	@Path("/{faultId}")
	void get(@PathParam("faultId") int faultId, MethodCallback<JobTypeDto> callback);

	@DELETE
	@Path("/{faultId}")
	void delete(@PathParam("faultId") int faultId, MethodCallback<Boolean> callback);

	@GET
	void getAll(MethodCallback<List<JobTypeDto>> callback );



	/**
	 * Utility class to get the instance of the Rest Service
	 */
	public static final class Util {

		private static JobTypeService instance;

		public static final JobTypeService get() {
			if (instance == null) {
				instance = GWT.create(JobTypeService.class);
				((RestServiceProxy) instance).setResource(new Resource(
						"http://localhost:8080/jobTypes"));
			}
			return instance;
		}

		private Util() {
			// Utility class should not be instantiated
		}
	}
}
