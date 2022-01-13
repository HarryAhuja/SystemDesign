package com.db;

import com.db.entity.Column;
import com.db.entity.ColumnType;
import com.db.entity.Database;
import com.db.entity.Query;
import com.db.entity.Table;

public class Driver {

	public static void main(String[] args)
	{
		Database db = new Database("Exam");
		
		Table table = new Table("Students");
		
		db.create_table(table);

		table.add_column(new Column("roll_no",ColumnType.Integer));
		table.add_column(new Column("name",ColumnType.String));
		table.add_column(new Column("age",ColumnType.Integer));
		table.add_column(new Column("contact",ColumnType.Integer));
		
		
		
		Query query = new Query();
		
		query.insert(db,"Insert into #Students#Values#harry#25#1234");
		query.insert(db,"Insert into #Students#Values#sherry#25#4566");
		query.insert(db,"Insert into #Students#Values#ajay#24#1234");
		
		// Select * from Students
		query.print_all(db,"Select All from #Students");
		
		// Select * from Students where age=25;
		query.filter_data(db,"Select All from #Students# where #name=harry#contact=1234");
		
		
		db.delete_table(table);
		
		db.print_all_data("Students");
		
		
	}

}
