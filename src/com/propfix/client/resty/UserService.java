
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
import com.propfix.client.dto.UserDto;


public interface UserService extends RestService{
	
    @POST
    void create(UserDto user, MethodCallback<UserDto> callback);

    @PUT
    void update(UserDto user, MethodCallback<UserDto> callback);

    @GET
    @Path("/{username}")
    void get(@PathParam("username") String username, MethodCallback<UserDto> callback);

    @DELETE
    @Path("/{username}")
    void delete(@PathParam("username") String username, MethodCallback<Boolean> callback);

    @GET
    void getAll(MethodCallback<UserDto> callback );
    
    @GET
    @Path("/search/usertype{?userType}")
    void getByUserType(@PathParam("userType") String username, MethodCallback<UserDto> callback);


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {

        private static UserService instance;

        public static final UserService get() {
            if (instance == null) {
                instance = GWT.create(UserService.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "http://localhost:8080/users"));
            }
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }
    }
	

}
