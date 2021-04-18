package com.shahzad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.shahzad.utils.BaseEntity;

/**
 * @author shahzad.hussain
 */
@Entity
@Table(name = Test.Columns.TABLE)
public class Test extends BaseEntity {

	private static final long serialVersionUID = -5737636883578044824L;

	public interface Columns {
		String TABLE = "tests";
		String QUERY = "CREATE TABLE tests (id INT AUTO_INCREMENT,department  NOT NULL,postedOn  NOT NULL,created_on DATETIME,modified_on DATETIME,created_by INTEGER,modified_by INTEGER,PRIMARY KEY (id));";
		String DEPARTMENT = "department";
		String POSTED_ON = "postedOn";
	}

	@Column(name = Columns.DEPARTMENT, nullable = false, unique = false)
	private String department;
	@Column(name = Columns.POSTED_ON, nullable = false, unique = false)
	private String postedOn;

	public String getDepartment() {
		return department;
	}

	public String getPostedOn() {
		return postedOn;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}

}