
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
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;
import com.propfix.client.dto.ContractorJobDto;
import com.propfix.client.dto.JobTypeDto;


public interface ContractorJobService {

	@POST
    void create(ContractorJobDto job, MethodCallback<ContractorJobDto> callback);

    @PUT
    void update(ContractorJobDto job, MethodCallback<ContractorJobDto> callback);

    @GET
    @Path("/{jobId}")
    void get(@PathParam("jobId") String jobId, MethodCallback<ContractorJobDto> callback);

    @DELETE
    @Path("/{jobId}")
    void delete(@PathParam("jobId") String jobId, MethodCallback<Boolean> callback);

    @GET
    void getAll(MethodCallback<List<ContractorJobDto>> callback );
    
    @GET
    @Path("/search/jobType{?jobTypeId}")
    void getByJobType(@PathParam("faultId") JobTypeDto jobTypeId, MethodCallback<ContractorJobDto> callback);
    


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {

        private static ContractorJobService instance;

        public static final ContractorJobService get() {
            if (instance == null) {
                instance = GWT.create(ContractorJobService.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "http://localhost:8080/contractorJobs"));
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }
    }
}
