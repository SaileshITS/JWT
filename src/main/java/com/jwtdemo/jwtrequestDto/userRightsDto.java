package com.jwtdemo.jwtrequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class userRightsDto {

	private Integer userId;
	private Integer userGroupID;
}
