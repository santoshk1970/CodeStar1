package net.amznsantosh.transform.model;

public class TransformEnvelope { 
	private DataToBeProtected transform;
	public TransformEnvelope(DataToBeProtected transform) {
		super();
		this.transform = transform;
	}

	public DataToBeProtected getTransform() {
		return transform;
	}

	public void setTransform(DataToBeProtected data) {
		this.transform = data;
	}
	
}
