package com.mycompany.restfulexample;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author marcus.costa
 */
public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}