
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
import com.propfix.client.dto.ContractorDto;

public interface ContractorService extends RestService{

	@POST
    void create(ContractorDto Contractor, MethodCallback<ContractorDto> callback);

    @PUT
    void update(ContractorDto Contractor, MethodCallback<ContractorDto> callback);

    @GET
    @Path("/{contractorId}")
    void get(@PathParam("contractorId") String contractorId, MethodCallback<ContractorDto> callback);

    @DELETE
    @Path("/{contractorId}")
    void delete(@PathParam("contractorId") String contractorId, MethodCallback<Boolean> callback);

    @GET
    void getAll(MethodCallback<List<ContractorDto>> callback );
    


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {

        private static ContractorService instance;

        public static final ContractorService get() {
            if (instance == null) {
                instance = GWT.create(ContractorService.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "http://localhost:8080/contractors"));
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }
    }
}
