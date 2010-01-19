package lawu.util;

import static lawu.util.iterator.Iterators.iterator;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Miorel-Lucian Palii
 */
public class ResourceBundleAdapter extends Dictionary<String, String> {
	private ResourceBundle bundle;
	
	public ResourceBundleAdapter(ResourceBundle bundle) {
		if(bundle == null)
			throw new RuntimeException("");
		this.bundle = bundle;
	}
	
	@Override
	public Enumeration<String> elements() {
		return this.bundle.getKeys();
	}

	@Override
	public String get(Object key) {
		String ret = null;
		try {
			ret = this.bundle.getString(key == null ? null : key.toString());
		}
		catch(MissingResourceException e) {
		}
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public Enumeration<String> keys() {
		return iterator(this.bundle.keySet());
	}

	@Override
	public String put(String key, String value) {
		throw new UnsupportedOperationException("");
	}

	@Override
	public String remove(Object key) {
		throw new UnsupportedOperationException("");
	}

	@Override
	public int size() {
		return this.bundle.keySet().size();
	}	
}
