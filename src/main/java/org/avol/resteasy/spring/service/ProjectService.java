package org.avol.resteasy.spring.service;

import org.avol.resteasy.spring.jaxb.Project;

import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lovababu on 9/6/2015.
 */
public interface ProjectService {
    Response create(Project var1) throws InvocationTargetException, IllegalAccessException;

    Response get(int var1) throws InvocationTargetException, IllegalAccessException;
}
