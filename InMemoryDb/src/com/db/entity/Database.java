package com.db.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Database
{
	private String 				  db_name;
	private HashMap<String,Table> hm;
	
	public Database()
	{
		db_name = null;
	}
	public Database(String s)
	{
		db_name = s;
		hm 		= new HashMap<>();
	}
	
	public String get_db_name()
	{
		return db_name;
	}
	public void set_db_name(String db_name)
	{
		this.db_name = db_name;
	}
	public HashMap<String, Table> get_db_hm()
	{
		return hm;
	}

	public boolean content_equals(Object o1,Object o2)
	{
		if(o2 instanceof Integer)	return o2.equals(Integer.parseInt((String)o1));
		else						return o2.equals((String)o1);
			
	}
	
	public void create_table(Table table)
	{
		if(hm.containsKey(table.get_table_name()))
		{
			System.out.println("Table already exists in db");
		}
		else
		{
			hm.put(table.get_table_name(),table);
		}
	}
	
	public void delete_table(Table table)
	{
		hm.remove(table.get_table_name());
	}
	
	public void print_all_data(String table_name)
	{
		if(hm.containsKey(table_name)==false)
		{
			System.out.println("Table doesn't exists in table");
			return;
			
		}
		Table table = hm.get(table_name);
		
		Iterator<Row> itr = table.get_table_rows_hm().values().iterator();
		
		while(itr.hasNext())
		{
			Row r = itr.next();
			r.print_row();
		}
		
	}
	
	public void filter(String table_name,HashMap<String,Object> data)
	{
		if(hm.containsKey(table_name)==false)
		{
			System.out.println("Table doesn't exists in table");
			return;
			
		}
		
		Table table = hm.get(table_name);
		
		Iterator<Row> itr = table.get_table_rows_hm().values().iterator();
		
		while(itr.hasNext())
		{
			Row r = itr.next();
			Iterator<Map.Entry<String, Object>> data_itr = data.entrySet().iterator();
			
			boolean match = true;
			
			while(data_itr.hasNext())
			{
				Map.Entry<String, Object> entry = data_itr.next();
				
				String col_name = entry.getKey();
				Object value	= entry.getValue();
				
				if(content_equals(r.get_row_hm().get(col_name),value)==false)
				{
					match = false;
					break;
				}
					
			}
			if(match)	r.print_row();
		}
	}
	
	
}
