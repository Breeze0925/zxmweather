package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * 该类用于创建数据表
 */
public class ZxmWeatherOpenHelper extends SQLiteOpenHelper {

	/*
	 * Provice建表语句
	 */
	public static final String CERATE_PROVINCE = "create table Province ("+
			"id integer primary key autoincrement, "+
			"province_name text, "+
			"province_code text)";			
	/*
	 * City建表语句
	 */
	public static final String CREATE_CITY = "create table City ("+
			"id integer primary key autoincrement, " +
			"city_name text, " +
			"city_code text, " +
			"province_id integer)";
	/*
	 * Country建表语句
	 */
	public static final String CREATE_COUNTRY = "create table Country (" +
			"id integer primary key autoincrement, " +
			"country_name text, " +
			"country_code text, " +
			"city_id integer)";
	
	public ZxmWeatherOpenHelper(Context context,String name,CursorFactory factory,int version) {
		super(context,name,factory,version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL(CERATE_PROVINCE); //创建Province表
		db.execSQL(CREATE_CITY); //创建City表
		db.execSQL(CREATE_COUNTRY);  //创建Country表
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根

	}

}
