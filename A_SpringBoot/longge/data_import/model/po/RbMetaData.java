package cn.com.geovis.data_import.data_import.model.po;

import java.util.Properties;

/**
* @author 作者
* @version 创建时间：2019年3月13日 下午3:54:50
* 类说明
*/
public class RbMetaData {
	
	private String mimeType;
	private String maxLevel;
	private String minLevel;
	private String gridset;
	private String maxX;
	private String maxY;
	private String minX;
	private String minY;
	
	public RbMetaData() {
		
	}
	
	public RbMetaData(Properties p) {
		String bounds = p.getProperty("bounds");
		String[] boundsArray = bounds.split(",");
		this.mimeType = p.getProperty("mimetype");
		this.maxLevel = p.getProperty("maxZoom");
		this.minLevel = p.getProperty("minZoom");
		this.gridset = p.getProperty("gridset");
		this.maxX = boundsArray[2];
		this.maxY = boundsArray[3];
		this.minX = boundsArray[0];
		this.minY = boundsArray[1];
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(String maxLevel) {
		this.maxLevel = maxLevel;
	}

	public String getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(String minLevel) {
		this.minLevel = minLevel;
	}

	public String getGridset() {
		return gridset;
	}

	public void setGridset(String gridset) {
		this.gridset = gridset;
	}

	public String getMaxX() {
		return maxX;
	}

	public void setMaxX(String maxX) {
		this.maxX = maxX;
	}

	public String getMaxY() {
		return maxY;
	}

	public void setMaxY(String maxY) {
		this.maxY = maxY;
	}

	public String getMinX() {
		return minX;
	}

	public void setMinX(String minX) {
		this.minX = minX;
	}

	public String getMinY() {
		return minY;
	}

	public void setMinY(String minY) {
		this.minY = minY;
	}
}
