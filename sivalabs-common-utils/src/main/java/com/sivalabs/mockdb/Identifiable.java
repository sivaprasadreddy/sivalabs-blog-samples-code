package com.sivalabs.mockdb;

import java.io.Serializable;

public interface Identifiable<K> extends Serializable {
	public void setId(K id);

	public K getId();
}
