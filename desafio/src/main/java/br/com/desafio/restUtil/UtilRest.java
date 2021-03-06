package br.com.desafio.restUtil;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import br.com.desafio.exception.PrincipalException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UtilRest {
	@Context
	private HttpHeaders headers;
	
	
	public ObjectMapper getObjectMapper() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return new ObjectMapper()
				.setDateFormat(dateFormat)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false)
				.configure(SerializationFeature.INDENT_OUTPUT, true)
				.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
	}

	public Response getResponseAdd(Object e) {
		return this.getResponse(new RestResponse(
				"Registro incluido com sucesso.", null, e),
				Response.Status.CREATED);
	}

	public Response getResponseEdit(Object data) {
		return this.getResponse(new RestResponse(
				"Registro alterado com sucesso.", null, data),
				Response.Status.OK);
	}

	public Response getResponseRemove(Object e) {
		return this.getResponse(new RestResponse(
				"Registro removido com sucesso.", null, e),
				Response.Status.OK);
	}

	public Response getResponseList(Object data) {
		return this.getResponse(new RestResponse(null, null, data),
				Response.Status.OK);
	}

	public Response getResponsePrivate() {
		return this
				.getResponse(
						new RestResponse(
								"Acesso negado.",
								"Esta funcionalidade não esta dísponivel para seu nível de acesso.",
								null), Response.Status.FORBIDDEN);
	}

	public Response getResponseUnauthorized(){
		return this
				.getResponse(
						new RestResponse(
								"Credenciais invalidas.",
								"Suas credenciais não são validas para este acesso.",
								null), Response.Status.UNAUTHORIZED);
	}
	
	public Response getResponseError(Exception e) {

		Response.Status status = null;
		if (e instanceof PrincipalException) {
			status = Response.Status.BAD_REQUEST;
		} else {
			status = Response.Status.INTERNAL_SERVER_ERROR;
		}

		return this.getResponse(new RestResponse(e), status);
	}

	private Response getResponse(Object obj, Response.Status status) {

		String json = null;
		try {
			json = this.getObjectMapper().writeValueAsString(obj);

			return Response.status(status).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(null).build();
		}
	}
	
}
