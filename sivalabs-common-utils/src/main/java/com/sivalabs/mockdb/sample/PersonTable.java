
package com.sivalabs.mockdb.sample;

import java.util.concurrent.atomic.AtomicInteger;

import com.sivalabs.mockdb.Table;

public class PersonTable extends Table<Integer, Person> {

	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

	@Override
	public Integer getNextId() {
		return ATOMIC_INTEGER.incrementAndGet();
	}

}
