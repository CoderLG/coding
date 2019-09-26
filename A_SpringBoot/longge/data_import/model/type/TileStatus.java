package cn.com.geovis.data_import.data_import.model.type;

public enum TileStatus {
	
	WAITING("准备中"),
	
	READY("未切片"),
	
	PROCESS("切片中"),
	
	STOP("切片停止"),
	
	SUCCESS("切片成功"),
	
	FAIL("切片失败");
	
	private final String runStatus;
	
	private TileStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	
	public String getRunStatus() {
		return runStatus;
	}
	
	public static TileStatus from(String runStatus){
		
		runStatus = runStatus.toUpperCase();
		
		if(runStatus.equals("WAITING"))
			return TileStatus.WAITING;
		
		if(runStatus.equals("READY"))
			return TileStatus.READY;
		
		if(runStatus.equals("PROCESS"))
			return TileStatus.PROCESS;
		
		if(runStatus.equals("STOP"))
			return TileStatus.STOP;
		
		if(runStatus.equals("SUCCESS"))
			return TileStatus.SUCCESS;
		
		if(runStatus.equals("FAIL"))
			return TileStatus.FAIL;
		
		return TileStatus.WAITING;
	}
	
}
