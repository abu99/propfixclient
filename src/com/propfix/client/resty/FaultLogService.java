
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
import com.propfix.client.dto.FaultLogDto;
import com.propfix.client.dto.JobTypeDto;


public interface FaultLogService {

	@POST
    void create(FaultLogDto faultLog, MethodCallback<FaultLogDto> callback);

    @PUT
    void update(FaultLogDto faultLog, MethodCallback<FaultLogDto> callback);

    @GET
    @Path("/{faultLogId}")
    void get(@PathParam("faultLogId") String faultLogId, MethodCallback<FaultLogDto> callback);

    @DELETE
    @Path("/{faultLogId}")
    void delete(@PathParam("faultLogId") String faultLogId, MethodCallback<Boolean> callback);

    @GET
    void getAll(MethodCallback<List<FaultLogDto>> callback );
    
    @GET
    @Path("/search/jobType{?jobTypeId}")
    void getByJobType(@PathParam("jobTypeId") JobTypeDto jobTypeId, MethodCallback<ContractorJobDto> callback);
    
    @GET
    @Path("/search/status{?status}")
    void getByStatus(@PathParam("status") String status, MethodCallback<ContractorJobDto> callback);
    
    


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {

        private static FaultLogService instance;

        public static final FaultLogService get() {
            if (instance == null) {
                instance = GWT.create(FaultLogService.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "http://localhost:8080/faultLogs"));
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }
    }
}
