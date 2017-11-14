package com.rest.tutorials.messanserInRest.reources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * shows different kind of param annotation can be used in REST
 * 
 * @author ketan
 *
 */
@Path("/injectedparam")
@Produces(MediaType.TEXT_PLAIN)
public class ParamDemoResource {

	@GET
	public String demoParam(@MatrixParam("matrixparam") String mparam, @HeaderParam("headerparam") String hparam,
			@CookieParam("cookieparam") String cparam) {
		return "matrix param value : " + mparam + "     " + "Header param: " + hparam + "     " + "Cookie param: "
				+ cparam;

	}

	@GET
	@Path("context")
	public String demoContext(@Context UriInfo uriInfo, @Context HttpHeaders headersInfo) {

		String uri = uriInfo.getAbsolutePath().toString();
		String cookies = headersInfo.getCookies().toString();
		return "URI : " + uri + "     cookies : " + cookies;
	}
}
