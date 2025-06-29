package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private Map<String,Object> context = new HashMap<>();
	
	public void setContext(String key, Object value) {
		context.put(key, value);
	}
	public Object getContext(String key) {
		return context.get(key);
	}
	public Boolean contains(String key) {
		return context.containsKey(key);
	}
}
