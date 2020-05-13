package com.datumredsoft.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/evento")
public class DbAdapterServices {
	
	@POST
	@Path("/guardarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEvento(String json) {
		
		System.out.println(json);
		
		
		return Response.ok("{\"respuesta\": \"Guardado Satisfactoriamente\"}", MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST
	@Path("/guardarRegistro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarRegistro(String json) {	
		
		System.out.println(json);
		
		
		return Response.ok("{\"respuesta\": \"Guardado Satisfactoriamente\"}", MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/getTiposEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTipoEvento() {	
		
		System.out.println("Get");
		
		
		return Response.ok("{\"respuesta\": \"Guardado Satisfactoriamente\"}", MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/getEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEvento(@QueryParam("id") int id) {	
		
		System.out.println("Get Evento" + id);
		
		
		return Response.ok("{\"respuesta\": \"Guardado Satisfactoriamente\"}", MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/getRegistrosByEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getRegistrosByEvento(@QueryParam("id_evento") int idEvento) {
		
		System.out.println("Get Registros" + idEvento);
		
		
		return Response.ok("{\"respuesta\": \"Guardado Satisfactoriamente\"}", MediaType.APPLICATION_JSON).build();
	}
	

}
