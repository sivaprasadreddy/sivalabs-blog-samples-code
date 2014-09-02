package com.sivalabs.mockdb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Table<PK extends Object, T extends Identifiable<PK>> {
	protected final Map<PK, T> table = new HashMap<PK, T>();

	public abstract PK getNextId();

	protected Table() {
	}

	public void create(T obj) {
		if (table.containsKey(obj.getId())) {
			throw new RuntimeException("PrimaryKey [" + obj.getId()
					+ "] already exists");
		}
		obj.setId(getNextId());
		table.put(obj.getId(), obj);
	}

	public Collection<T> getAll() {
		return table.values();
	}

	public T getById(PK id) {
		return table.get(id);
	}

	public void update(T obj) {
		if (!table.containsKey(obj.getId())) {
			throw new RuntimeException("PrimaryKey [" + obj.getId()
					+ "] doesn't exists");
		}
		table.put(obj.getId(), obj);
	}

	public void delete(T obj) {
		delete(obj.getId());
	}

	public void delete(PK id) {
		if (!table.containsKey(id)) {
			throw new RuntimeException("PrimaryKey [" + id + "] doesn't exists");
		}
		table.remove(id);
	}
}
