package cn.com.geovis.data_import.data_import.model.type;

public enum Gridset {
	
	EPSG4326(4326) {
		@Override
		public int[] computeLevelRange(double rasterX, double rasterY, double minX, double minY, double maxX,
				double maxY,int tileSize) {
			
			double[] bbox = new double[] {minX,minY,maxX,maxY};

			// 数组0为经度，1为纬度 左下
			double[] leftDown = { bbox[0], bbox[1] };
			// 右上经纬度
			double[] rightUp = { bbox[2], bbox[3]};

			double xl = rightUp[0] - leftDown[0];
			double yl = rightUp[1] - leftDown[1];

			double levelZeroRange = 180.0;

			// 获取每个像素对应的经纬跨度
			double xr = xl / rasterX;
			double yr = yl / rasterY;

			double[] resolutions = new double[] { xr, yr };
			double levelatX = (Math.log(Math.abs(resolutions[0] * tileSize) / levelZeroRange) / Math.log(0.5));
			double levelatY = (Math.log(Math.abs(resolutions[1] * tileSize) / levelZeroRange) / Math.log(0.5));

			int bestSuit = (int) Math.ceil(((levelatX + levelatY) / 2.0) - 0.4);
			double step = xl > yl ? xl : yl;

			int maxLevel = bestSuit;
			int minLevel = (int) (Math.log(180.0 / step) / Math.log(2.0) - 0.4);
			minLevel = Math.max(minLevel, 0);

			return new int[] { minLevel, maxLevel };
		}
	},
	
	EPSG3857(3857) {
		@Override
		public int[] computeLevelRange(double rasterX, double rasterY, double minX, double minY, double maxX,
				double maxY,int tileSize) {

			
			double[] bbox = new double[] {minX,minY,maxX,maxY};

			// 数组0为经度，1为纬度 左下
			double[] leftDown = { bbox[0], bbox[1] };
			// 右上经纬度
			double[] rightUp = { bbox[2], bbox[3]};

			double xl = rightUp[0] - leftDown[0];
			double yl = rightUp[1] - leftDown[1];

			double levelZeroRange = 180.0;

			// 获取每个像素对应的经纬跨度
			double xr = xl / rasterX;
			double yr = yl / rasterY;

			double[] resolutions = new double[] { xr, yr };
			double levelatX = (Math.log(Math.abs(resolutions[0] * tileSize) / levelZeroRange) / Math.log(0.5));
			double levelatY = (Math.log(Math.abs(resolutions[1] * tileSize) / levelZeroRange) / Math.log(0.5));

			int bestSuit = (int) Math.ceil(((levelatX + levelatY) / 2.0) - 0.4);
			double step = xl > yl ? xl : yl;

			int maxLevel = bestSuit;
			int minLevel = (int) (Math.log(180.0 / step) / Math.log(2.0) - 0.4);
			minLevel = Math.max(minLevel, 0);

			return new int[] { minLevel, maxLevel };
		
		}
	};  
	
	private int epsgCode;
	
	Gridset(int epsgCode) {
		this.epsgCode = epsgCode;
	}
	
	public static Gridset from(String gridset) {
		if(gridset.equalsIgnoreCase("EPSG:4326") || 
				gridset.equalsIgnoreCase("4326"))
			return EPSG4326;
		if(gridset.equalsIgnoreCase("EPSG:3857") || 
				gridset.equalsIgnoreCase("3857"))
			return EPSG3857;
		return EPSG4326;
	}
	
	@Override
	public String toString() {
		return "EPSG:" + epsgCode;
	}
	
	/**
     * 
     * 根据指定的经纬度范围和影像宽高来自动计算出一个最合适的层级范围
     * 
     * @author 李小飞
     * @param rasterX
     * @param rasterY
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     * @return 层级的数组，
     */
    public abstract int[] computeLevelRange(double rasterX, double rasterY, double minX, double minY, double maxX,
			double maxY, int tileWidth);
    
    public int[] computeLevelRange(double rasterX, double rasterY, double minX, double minY, double maxX,
			double maxY) {
    	return computeLevelRange(rasterX, rasterY, minX, minY, maxX, maxY,256);
    }

}
