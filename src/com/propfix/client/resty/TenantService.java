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
import com.propfix.client.dto.TenantDto;

public interface TenantService extends RestService{

	@POST
    void create(TenantDto tenant, MethodCallback<TenantDto> callback);

    @PUT
    void update(TenantDto tenant, MethodCallback<TenantDto> callback);

    @GET
    @Path("/{tenantId}")
    void get(@PathParam("tenantId") String tenantId, MethodCallback<TenantDto> callback);

    @DELETE
    @Path("/{tenantId}")
    void delete(@PathParam("tenantId") String tenantId, MethodCallback<Boolean> callback);

    @GET
    void getAll(MethodCallback<List<TenantDto>> callback );
    


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {

        private static TenantService instance;

        public static final TenantService get() {
            if (instance == null) {
                instance = GWT.create(TenantService.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "http://localhost:8080/tenants"));
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }
    }
}
