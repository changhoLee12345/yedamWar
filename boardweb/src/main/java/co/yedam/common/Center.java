package co.yedam.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Center {
	private int id;
	private String centerName;
	private String sido;
	private String address;
	private String centerType;
	private String createdAt;
	private String facilityName;
	private String lat;
	private String lng;
	private String org;
	private String phoneNumber;
	private String sigungu;
	private String updatedAt;
	private String zipCode;

	public Center(int id, String centerName, String sido) {
		this.id = id;
		this.centerName = centerName;
		this.sido = sido;
	}
}
