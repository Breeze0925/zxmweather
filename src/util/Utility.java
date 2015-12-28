package util;

import model.City;
import model.Country;
import model.Province;
import model.ZxmWeatherDB;
import android.text.TextUtils;

public class Utility {

	/*
	 * 解析和处理服务器返回的省级数据
	 */
	public synchronized static boolean handleProvincesResponse(ZxmWeatherDB zxmWeatherDB,String response) {
		if(!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if(allProvinces != null && allProvinces.length > 0) {
				for(String p: allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//将解析出来的数据存储到Province表
					zxmWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 解析和处理服务器返回的市级数据
	 */
	public static boolean handleCitiesResponse(ZxmWeatherDB zxmWeatherDB,String response,int provinceId) {
		if(!TextUtils.isEmpty(response)) {
			String[] allCities = response.split(",");
			if(allCities !=null && allCities.length>0) {
				for(String c: allCities) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//将解析出来的数据存储到City表
					zxmWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return true;
	}
	
	/*
	 *解析和处理服务器返回的县级数据
	 */
	public static boolean handleCountiesResponse(ZxmWeatherDB zxmWeatherDB,String response,int cityId) {
		if(!TextUtils.isEmpty(response)) {
			String[] allCounties = response.split(",");
			if(allCounties != null && allCounties.length>0) {
				for(String c : allCounties) {
					String[] array = c.split("\\|");
					Country country = new Country();
					country.setCountryCode(array[0]);
					country.setCountryName(array[1]);
					country.setCityId(cityId);
					//将解析处理啊的数据存储到Country表
					zxmWeatherDB.saveCountry(country);
				}
				return true;
			}
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
}
