package com.db.entity;

public class Column
{
	ColumnType type;
	String	   name;
	
	public Column()
	{
		type  = null;
		name  = null;
	}
	public Column(String n,ColumnType t)
	{
		type  = t;
		name  = n;
	}

	public ColumnType get_column_type()
	{
		return type;
	}
	public void get_column_type(ColumnType type)
	{
		this.type = type;
	}
	public String get_column_name()
	{
		return name;
	}
	public void set_column_name(String name)
	{
		this.name = name;
	}
}
