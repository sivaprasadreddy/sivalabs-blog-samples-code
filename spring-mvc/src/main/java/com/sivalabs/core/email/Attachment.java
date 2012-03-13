package com.sivalabs.core.email;

public class Attachment {
	private byte[] data;
	private String filename;
	private String mimeType;
	private boolean inline;

	public Attachment() {
	}

	public Attachment(byte[] data, String filename, String mimeType) {
		this.data = data;
		this.filename = filename;
		this.mimeType = mimeType;
	}

	public Attachment(byte[] data, String filename, String mimeType,
			boolean inline) {
		this.data = data;
		this.filename = filename;
		this.mimeType = mimeType;
		this.inline = inline;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public boolean isInline() {
		return inline;
	}

	public void setInline(boolean inline) {
		this.inline = inline;
	}

}
