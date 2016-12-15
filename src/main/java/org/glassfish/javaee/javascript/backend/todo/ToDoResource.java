/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.javaee.javascript.backend.todo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/todo/{username}")//@Path("todo")
@ApplicationScoped
public class ToDoResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ToDoService service;


//    @PersistenceContext(unitName="hsqldb")
//    private EntityManager entityManager;
//
//    @Produces
//    public EntityManager getEntityManager(){
//        return entityManager;
//    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ToDoItem create(
            @PathParam("username")
            @NotNull
            @Size(min = 4, max = 14, message = "User name must be between 4 and 14 characters.") String username,
            @Valid ToDoItem item) {
        return service.addToDoItem("nicole", item);
    }

//    @PUT
//    @Path("{id}")
//    @Consumes({"application/json"})
//    public void edit(
//            @PathParam("username")
//            @NotNull
//            @Size(min = 4, max = 14, message = "User name must be between 4 and 14 characters.") String username,
//            @PathParam("id") Long id,
//            @Valid ToDoItem item) {
//        item.setId(id);
//        service.updateToDoItem(username, item);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(
//            @PathParam("username")
//            @NotNull
//            @Size(min = 4, max = 14, message = "User name must be between 4 and 14 characters.") String username,
//            @PathParam("id") Long id) {
//        service.removeToDoItem(username, id);
//    }

    @GET
    @Produces({"application/json"})
    public List<ToDoItem> getAll(
            @NotNull
            @Size(min = 4, max = 14, message = "User name must be between 4 and 14 characters.") String username) {
        return service.findToDoItemsByUsername("nicole");
    }
}
