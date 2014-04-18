package cs524builder.taskone;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

	private String id, component;
	private List<String> volume = new ArrayList<String>();
	private List<String> socket = new ArrayList<String>();
	private List<String> export = new ArrayList<String>();
	
	public Blocks() {
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setComponent(String component) {
		this.component = component;
	}
	
	public void setVolume(List<String> volume) {
		this.volume = volume;
	}
	
	public void setSocket(List<String> socket) {
		this.socket = socket;
	}
	
	public void setExport(List<String> export) {
		this.export = export;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getComponent() {
		return this.component;
	}
	
	public List<String> getVolume() {
		return this.volume;
	}
	
	public List<String> getSocket() {
		return this.socket;
	}
	
	public List<String> getExport() {
		return this.export;
	}
}
