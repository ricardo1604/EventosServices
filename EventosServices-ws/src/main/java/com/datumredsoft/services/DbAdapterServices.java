package com.datumredsoft.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.datumredsoft.model.MktEvento;
import com.datumredsoft.model.MktRegistro;
import com.datumredsoft.model.MktTipoEvento;
import com.datumredsoft.pojo.Evento;
import com.datumredsoft.pojo.Registro;
import com.datumredsoft.pojo.Respuesta;
import com.datumredsoft.pojo.TipoEvento;
import com.google.gson.Gson;

@Path("/evento")
public class DbAdapterServices {
	
	private static final String UNUSED = "unused";
	private static final String PERSISTENCE_UNIT_NAME = "EventosServices-ws-PU";
    private static EntityManagerFactory factory;
	
    //@Resource(lookup="java:jboss/mail/events")
    //private Session session;
    
	@POST
	@Path("/guardarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEvento(String json) {
		try {
			System.out.println(json);
			
			Evento e = convertJsonToObj(new Evento(), json);
			
			MktEvento mktEvent = new MktEvento();
			
			mktEvent.setDescripcion(e.getDescripcion());
			mktEvent.setDuracion(e.getDuracion());
			mktEvent.setFecha(e.getFecha());
			mktEvent.setHora(e.getHora());
			mktEvent.setNombre(e.getNombre());
			mktEvent.setTemas(e.getTemas());
			mktEvent.setUbicacion(e.getUbicacion());
			mktEvent.setIdTipoEvento(Integer.parseInt(e.getIdTipoEvento()));
			
			mktEvent = saveObj(mktEvent);
			
			int codEvent = mktEvent.getIdEvento();
			
			Respuesta resp = new Respuesta();
			resp.setCodigo(codEvent);
			resp.setRepuesta("Evento guardado satisfactoriamente con código: " + codEvent);
			
			String jsonRes = convertObjToJson(resp);
			
			return Response.ok(jsonRes, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	
	@POST
	@Path("/guardarRegistro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarRegistro(String json) {	
		try {
			System.out.println(json);
			
			Registro r = convertJsonToObj(new Registro(), json);
			
			MktRegistro mktr = new MktRegistro();
			
			mktr.setApellidos(r.getApellidos());
			mktr.setAsistencia((byte) r.getAsistencia());
			mktr.setCiudad(r.getCiudad());
			mktr.setDepartamento(r.getDepartamento());
			mktr.setEmail(r.getEmail());
			mktr.setEmpresa(r.getEmpresa());
			mktr.setNombres(r.getNombres());
			mktr.setNumTelefono(r.getNumTelefono());
			mktr.setPais(r.getPais());
			mktr.setCargo(r.getCargo());
			MktEvento event = new MktEvento();
			event.setIdEvento(r.getIdEvento());
			mktr.setMktEvento(event);

			mktr = saveObj(mktr);
			
			int id = mktr.getIdInvitado();
			
			enviarCorreo();
			
			Respuesta res = new Respuesta();
			res.setCodigo(id);
			res.setRepuesta("Resgistro realizado satisfactoriamente");
			
			String jsonRes = convertObjToJson(res);
			
			
			return Response.ok(jsonRes, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@GET
	@Path("/getTiposEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTipoEvento() {	
		try {
			System.out.println("Get");
			
			List<MktTipoEvento>  tiposEventosList = queryObject("SELECT m FROM MktTipoEvento m", true);
			List<TipoEvento> tiposEvento = new ArrayList<>();
			
			for (MktTipoEvento te : tiposEventosList) {
				TipoEvento t = new TipoEvento();
				
				t.setIdTipoEvento(te.getIdTipoEvento()+"");
				t.setTipoEvento(te.getNombre());
				
				tiposEvento.add(t);
			}
			
			String json = convertObjToJson(tiposEvento);
			System.out.println(json);
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/getEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEvento(@QueryParam("id") int id) {	
		try {
			System.out.println("Get Evento" + id);
			MktEvento mkte = queryObject("SELECT m FROM MktEvento m WHERE m.idEvento="+id, false);
			
			Evento event = new Evento();
			
			event.setId(mkte.getIdEvento());
			event.setDescripcion(mkte.getDescripcion());
			event.setDuracion(mkte.getDuracion());
			event.setFecha(mkte.getFecha());
			event.setHora(mkte.getHora());
			event.setIdTipoEvento(mkte.getIdEvento()+"");
			event.setNombre(mkte.getNombre());
			event.setTemas(mkte.getTemas());
			event.setUbicacion(mkte.getUbicacion());
			
			String json = convertObjToJson(event);
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
	
	
	@GET
	@Path("/getRegistrosByEvento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getRegistrosByEvento(@QueryParam("id_evento") int idEvento) {
		try {
			System.out.println("Get Registros" + idEvento);
			
			List<MktRegistro> registros = queryObject("SELECT m FROM MktRegistro m WHERE m.mktEvento.idEvento="+idEvento, true);
			List<Registro> registrosList = new ArrayList<>();
					
			for (MktRegistro r : registros) {
				Registro reg = new Registro();
				
				reg.setApellidos(r.getApellidos());
				reg.setAsistencia(r.getAsistencia());
				reg.setCargo(r.getCargo());
				reg.setCiudad(r.getCiudad());
				reg.setDepartamento(r.getDepartamento());
				reg.setEmail(r.getEmail());
				reg.setEmpresa(r.getEmpresa());
				reg.setId(r.getIdInvitado());
				reg.setIdEvento(idEvento);
				reg.setNombres(r.getNombres());
				reg.setNumTelefono(r.getNumTelefono());
				reg.setPais(r.getPais());
				
				registrosList.add(reg);
			}
			
			String json = convertObjToJson(registrosList);
			
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
	
	
	@SuppressWarnings({ "unchecked", UNUSED })
	private <T> T queryObject(String query, boolean isList) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
	        
	        Query q = em.createQuery(query);
	        if (isList) {
	        	return (T) q.getResultList();
	        } else {
	        	return (T) q.getSingleResult();
	        }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
		
	}
	
	@SuppressWarnings(UNUSED)
	private <T> T saveObj(T t) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
        	
        	em.getTransaction().begin();
        	t = em.merge(t);
        	em.getTransaction().commit();
        	em.close();
        	
	        return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	private <T> T convertJsonToObj(T t, String json) {
		Gson g = new Gson();
		
		t = (T) g.fromJson(json, t.getClass());
		
		return t;
	}
	
	@SuppressWarnings(UNUSED)
	private <T> String convertObjToJson(T t) {
		Gson g = new Gson();
		
		String json = g.toJson(t);
		
		return json;
	}
	
	private void enviarCorreo() {
		try {
			Session session = getEmailSession();
		    MimeMessage message = new MimeMessage(session);
		    
		    message.setFrom("no-Reply@datumredsoft.com");
	        message.addRecipients(Message.RecipientType.TO, "ricardo.sosa@datumredsoft.com");   //Se podrían añadir varios de la misma manera
	        message.setSubject("TEST - Se ha inscrito satisfactoriamente");
	        message.setText("Hola");
			
	        Transport transport = session.getTransport();
	        
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	private Session getEmailSession() throws Exception{  
        InitialContext context = new InitialContext();  
        return (Session) context.lookup("java:jboss/mail/events");  
    } 

}
