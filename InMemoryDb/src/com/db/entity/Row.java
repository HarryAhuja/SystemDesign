package com.db.entity;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Row
{
	private Integer row_id;
	// Column name and its value
	private LinkedHashMap<String,Object> hm;
	
	Row()
	{
		row_id = -1;
		hm	   = null;
	}
	Row(Integer r, LinkedHashMap<String,Object> h)
	{
		row_id = r;
		hm	   = h;
	}
	public Integer get_row_id()
	{
		return row_id;
	}
	public void set_row_id(Integer r)
	{
		row_id = r;
	}
	public LinkedHashMap<String, Object> get_row_hm()
	{
		return hm;
	}
	
	public void print_row()
	{
		Iterator<Object> itr = hm.values().iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}	
}
