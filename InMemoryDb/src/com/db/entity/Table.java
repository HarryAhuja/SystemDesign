package com.db.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Table
{
	private Integer				 id;
	private String 				 table_name;
	private HashMap<Integer,Row> rows_hm;
	
	// Create linked hashmap to maintain order of cols
	private LinkedHashMap<String,Column> cols_hm;
	
	public Table()
	{
		table_name = null;
		id		   = -1;
	}
	public Table(String s)
	{
		table_name = s;
		id		   = -1;
		rows_hm    = new HashMap<>();
		cols_hm    = new LinkedHashMap<>();
	}
	
	public void set_id(Integer i)
	{
		id = i;
	}
	
	public Integer get_id()
	{
		id++;
		return id;
	}
	
	public String get_table_name()
	{
		return table_name;
	}
	public void set_table_name(String table_name)
	{
		this.table_name = table_name;
	}
	public HashMap<Integer, Row> get_table_rows_hm()
	{
		return rows_hm;
	}
	public LinkedHashMap<String, Column> get_table_column_hm()
	{
		return cols_hm;
	}
	
	public void insert_row(LinkedHashMap<String,Object> map)
	{
		Integer auto_id = get_id();
		
		rows_hm.put(auto_id, new Row(auto_id,new LinkedHashMap<String,Object>(map)));
	}
	
	public void add_column(Column c)
	{
		if(cols_hm.containsKey(c.get_column_name())==false)
		{
			cols_hm.put(c.get_column_name(),c);
		}
		else
		{
			System.out.println("Column already exists in db");
		}
	}
	
	
	
	
		
}
