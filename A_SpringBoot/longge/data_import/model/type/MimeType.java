package cn.com.geovis.data_import.data_import.model.type;

public enum MimeType {

	JPEG,

	PNG,

	GEOJSON,

	TIFF,

	PRODUCT,

	TERRAIN;

	private static final String IMAGE_JPEG = "image/jpeg";
	private static final String IMAGE_PNG = "image/png";
	private static final String IMAGE_TIF = "image/tif";
	private static final String IMAGE_TIFF = "image/tiff";
	private static final String IMAGE_TERRAIN = "image/terrain";
	private static final String VECTOR_GEOJSON = "application/json;type=geojson";

	public String toMimeType() {

		if (this.equals(MimeType.JPEG))
			return IMAGE_JPEG;
		if (this.equals(MimeType.PNG))
			return IMAGE_PNG;
		if (this.equals(MimeType.TIFF))
			return IMAGE_TIFF;
		if (this.equals(MimeType.TERRAIN))
			return IMAGE_TERRAIN;
		if (this.equals(MimeType.GEOJSON))
			return VECTOR_GEOJSON;

		return IMAGE_PNG;
	}

	public String toFormat() {
		if (this.equals(MimeType.JPEG))
			return "jpeg";
		if (this.equals(MimeType.PNG))
			return "png";
		if (this.equals(MimeType.TIFF))
			return "tiff";
		if (this.equals(MimeType.GEOJSON))
			return "geojson";
		if (this.equals(MimeType.TERRAIN))
			return "terrain";
		return "png";
	}

	public static MimeType from(String mimeType) {

		mimeType = mimeType.toLowerCase();

		if (mimeType.equals("jpeg") || mimeType.equals("jpg") || mimeType.equals(IMAGE_JPEG))
			return MimeType.JPEG;

		if (mimeType.equals("png") || mimeType.equals(IMAGE_PNG))
			return MimeType.PNG;

		if (mimeType.equals("tif") || mimeType.equals("tiff") || mimeType.equals(IMAGE_TIF)
				|| mimeType.equals(IMAGE_TIFF))
			return MimeType.TIFF;

		if (mimeType.equals("terrain") || mimeType.equals(IMAGE_TERRAIN))
			return MimeType.TERRAIN;

		if (mimeType.equals("product"))
			return MimeType.PRODUCT;

		if (mimeType.equals("geojson"))
			return MimeType.GEOJSON;

		return MimeType.PNG;
	}

}
