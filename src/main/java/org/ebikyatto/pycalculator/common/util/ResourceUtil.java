package org.ebikyatto.pycalculator.common.util;

import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;

public final class ResourceUtil {
	
	private ResourceUtil() {
	}
	
	public static URL getURL(String name) {
		return ClassLoader.class.getResource(name);
	}
	
	public static InputStream getInputStream(String name) {
		return ClassLoader.class.getResourceAsStream(name);
	}
	
	public static Image getImage(String name) {
		return new Image(getInputStream(name));
	}
	
	public static String getPath(String name) {
		return getURL(name).toExternalForm();
	}
}
