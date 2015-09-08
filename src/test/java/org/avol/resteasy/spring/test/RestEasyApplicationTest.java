package org.avol.resteasy.spring.test;

import org.avol.resteasy.spring.client.ProjectServiceClientIface;
import org.avol.resteasy.spring.jaxb.Project;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lovababu on 9/5/2015.
 */
public class RestEasyApplicationTest {

    Client client = new ResteasyClientBuilder().build();
    ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) client.target("http://localhost:8080/RESTEasySpringIntegration/rest/project");
    ProjectServiceClientIface projectServiceClientIface = resteasyWebTarget.proxy(ProjectServiceClientIface.class);

    @Test
    public void testCreateProjectService() {


        //Instantiating Jaxb for request body.
        Project project = new Project();
        project.setId(3);
        project.setName("Google");
        project.setTechnology("Java");
        project.setTeamSize(50);
        //invoking the create service.
        Response response = projectServiceClientIface.create(project);
        assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

    }

    @Test
    public void getProjectService() {
        //invoking the get service.

        Response getResponse = projectServiceClientIface.get(3);
        assertEquals(getResponse.getStatus(), Response.Status.OK.getStatusCode());
        assertEquals("Google", getResponse.readEntity(Project.class).getName());
    }
}
