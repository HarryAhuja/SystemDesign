package com.db.entity;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class Query
{
	public void insert(Database db,String query)
	{
	
		String values[] = query.split("#");
		
		Table table = db.get_db_hm().get(values[1]);
		
		LinkedHashMap<String,Object> row = new LinkedHashMap<>();
		
		row.put("name",values[3]);
		row.put("age",values[4]);
		row.put("contact",values[5]);
		
		table.insert_row(row);
	}
	
	public void print_all(Database db,String query)
	{
		
		String values[] = query.split("#");
		
		Table table = db.get_db_hm().get(values[1]);
		
		System.out.println("All records from "+table.get_table_name()+" table");
		
		db.print_all_data(table.get_table_name());
		
		System.out.println();
	}
	
	public void filter_data(Database db,String query)
	{
		//Select All from #Students# where #age=25#contact=1234"
		
		String values[] = query.split("#");
		
		Table table = db.get_db_hm().get(values[1]);
		
		HashMap<String,Object> data = new HashMap<>();
		
		for(int i=3;i<values.length;i++)
		{
			String filter_cols[]    = values[i].split("=");
			String      column_name = filter_cols[0];
			ColumnType	type		= table.get_table_column_hm().get(column_name).type;

			if(type == ColumnType.Integer)
			{
				data.put(column_name, Integer.parseInt(filter_cols[1]));
			}
			else
			{
				data.put(column_name, filter_cols[1]);
			}
		}
		
		db.filter(table.get_table_name(),data);
		
		System.out.println();
	}
}
