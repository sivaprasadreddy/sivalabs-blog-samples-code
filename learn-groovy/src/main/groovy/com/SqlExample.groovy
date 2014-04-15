package com

import groovy.sql.Sql;

class SqlExample {

	static main(args) {
		Sql sql = Sql.newInstance([url: 'jdbc:mysql://localhost:3306/blog',
			user:'root',
			password:'admin',
			driverClassName:'com.mysql.jdbc.Driver']);
		sql.eachRow('select * from users',{user->
			println('Email :'+user.email)
		});
	}

}
