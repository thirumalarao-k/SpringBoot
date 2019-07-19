package com.hcl.msa.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class JobIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

		String prefix = "JOB";
		Connection connection = session.connection();
		Statement statement =null;
		ResultSet rs =null;
		try {
			statement = connection.createStatement();

			rs = statement.executeQuery("select count(job_Id) as jobId from msa_studio.job;");

			if (rs.next()) {
				int id = rs.getInt(1) + 100;
				String generatedId = prefix + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
			/*if(statement !=null)
				statement.close();
			if(connection !=null)
				connection.close();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
			if(statement !=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(connection !=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}*/

		return null;
	}

}
